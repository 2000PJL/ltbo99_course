/* USER CODE BEGIN Header */
/**
  ******************************************************************************
  * File Name          : freertos.c
  * Description        : Code for freertos applications
  ******************************************************************************
  * @attention
  *
  * <h2><center>&copy; Copyright (c) 2021 STMicroelectronics.
  * All rights reserved.</center></h2>
  *
  * This software component is licensed by ST under Ultimate Liberty license
  * SLA0044, the "License"; You may not use this file except in compliance with
  * the License. You may obtain a copy of the License at:
  *                             www.st.com/SLA0044
  *
  ******************************************************************************
  */
/* USER CODE END Header */

/* Includes ------------------------------------------------------------------*/
#include "FreeRTOS.h"
#include "task.h"
#include "main.h"
#include "cmsis_os.h"

/* Private includes ----------------------------------------------------------*/
/* USER CODE BEGIN Includes */
extern short wifi_count;
extern uint8_t wifi_rxbuf[Wifi_BufSize];

float adc_val = 0;
DHT11_Data_TypeDef dht11_data;


/* USER CODE END Includes */

/* Private typedef -----------------------------------------------------------*/
/* USER CODE BEGIN PTD */

/* USER CODE END PTD */

/* Private define ------------------------------------------------------------*/
/* USER CODE BEGIN PD */

/* USER CODE END PD */

/* Private macro -------------------------------------------------------------*/
/* USER CODE BEGIN PM */

/* USER CODE END PM */

/* Private variables ---------------------------------------------------------*/
/* USER CODE BEGIN Variables */

/* USER CODE END Variables */
osThreadId WIFISendTaskHandle;
osThreadId WIFIRecTaskHandle;
osThreadId DHT11TaskHandle;
osThreadId LightTaskHandle;

/* Private function prototypes -----------------------------------------------*/
/* USER CODE BEGIN FunctionPrototypes */

/* USER CODE END FunctionPrototypes */

void StartWIFISendTask(void const * argument);
void StartWIFIRecTask(void const * argument);
void StartDHT11Task(void const * argument);
void StarLightTask(void const * argument);

void MX_FREERTOS_Init(void); /* (MISRA C 2004 rule 8.1) */

/* GetIdleTaskMemory prototype (linked to static allocation support) */
void vApplicationGetIdleTaskMemory( StaticTask_t **ppxIdleTaskTCBBuffer, StackType_t **ppxIdleTaskStackBuffer, uint32_t *pulIdleTaskStackSize );

/* USER CODE BEGIN GET_IDLE_TASK_MEMORY */
static StaticTask_t xIdleTaskTCBBuffer;
static StackType_t xIdleStack[configMINIMAL_STACK_SIZE];

void vApplicationGetIdleTaskMemory( StaticTask_t **ppxIdleTaskTCBBuffer, StackType_t **ppxIdleTaskStackBuffer, uint32_t *pulIdleTaskStackSize )
{
  *ppxIdleTaskTCBBuffer = &xIdleTaskTCBBuffer;
  *ppxIdleTaskStackBuffer = &xIdleStack[0];
  *pulIdleTaskStackSize = configMINIMAL_STACK_SIZE;
  /* place for user code */
}
/* USER CODE END GET_IDLE_TASK_MEMORY */

/**
  * @brief  FreeRTOS initialization
  * @param  None
  * @retval None
  */
void MX_FREERTOS_Init(void) {
  /* USER CODE BEGIN Init */

  /* USER CODE END Init */

  /* USER CODE BEGIN RTOS_MUTEX */
  /* add mutexes, ... */
  /* USER CODE END RTOS_MUTEX */

  /* USER CODE BEGIN RTOS_SEMAPHORES */
  /* add semaphores, ... */
  /* USER CODE END RTOS_SEMAPHORES */

  /* USER CODE BEGIN RTOS_TIMERS */
  /* start timers, add new ones, ... */
  /* USER CODE END RTOS_TIMERS */

  /* USER CODE BEGIN RTOS_QUEUES */
  /* add queues, ... */
  /* USER CODE END RTOS_QUEUES */

  /* Create the thread(s) */
  /* definition and creation of WIFISendTask */
  osThreadDef(WIFISendTask, StartWIFISendTask, osPriorityNormal, 0, 128);
  WIFISendTaskHandle = osThreadCreate(osThread(WIFISendTask), NULL);

  /* definition and creation of WIFIRecTask */
  osThreadDef(WIFIRecTask, StartWIFIRecTask, osPriorityNormal, 0, 128);
  WIFIRecTaskHandle = osThreadCreate(osThread(WIFIRecTask), NULL);

  /* definition and creation of DHT11Task */
  osThreadDef(DHT11Task, StartDHT11Task, osPriorityAboveNormal, 0, 256);
  DHT11TaskHandle = osThreadCreate(osThread(DHT11Task), NULL);

  /* definition and creation of LightTask */
  osThreadDef(LightTask, StarLightTask, osPriorityNormal, 0, 128);
  LightTaskHandle = osThreadCreate(osThread(LightTask), NULL);

  /* USER CODE BEGIN RTOS_THREADS */
  /* add threads, ... */
  /* USER CODE END RTOS_THREADS */

}

/* USER CODE BEGIN Header_StartWIFISendTask */
/**
  * @brief  Function implementing the WIFISendTask thread.
  * @param  argument: Not used
  * @retval None
  */
/* USER CODE END Header_StartWIFISendTask */
void StartWIFISendTask(void const * argument)
{
  /* USER CODE BEGIN StartWIFISendTask */
  /* Infinite loop */
	osThreadSuspend(WIFISendTaskHandle);
	char tx_buf[128];
  for(;;)
  {
      osDelay(2900);
      sprintf(tx_buf, "#,%.2f,%.2f,%.2f,$", dht11_data.temperature, dht11_data.humidity, adc_val);
      Wifi_SendData(tx_buf);
  }
  /* USER CODE END StartWIFISendTask */
}

/* USER CODE BEGIN Header_StartWIFIRecTask */
/**
* @brief Function implementing the WIFIRecTask thread.
* @param argument: Not used
* @retval None
*/
/* USER CODE END Header_StartWIFIRecTask */
void StartWIFIRecTask(void const * argument)
{
  /* USER CODE BEGIN StartWIFIRecTask */
  /* Infinite loop */
  for(;;)
  {
    if(wifi_count == -1)
		{
			wifi_count = 0;
			printf("%s\r\n", wifi_rxbuf);
            if(strcmp((char *)wifi_rxbuf, "open_led1") == 0)
            {
                LED0_ON();
            }
            else if(strcmp((char *)wifi_rxbuf, "close_led1") == 0)
            {
                LED0_OFF();
            }
            else if(strcmp((char *)wifi_rxbuf, "open_led2") == 0)
            {
                LED1_ON();
            }
            else if(strcmp((char *)wifi_rxbuf, "close_led2") == 0)
            {
                LED1_OFF();
            }
            else if(strcmp((char *)wifi_rxbuf, "open_led3") == 0)
            {
                LED2_ON();
            }
            else if(strcmp((char *)wifi_rxbuf, "close_led3") == 0)
            {
                LED2_OFF();
            }
            else if(strcmp((char *)wifi_rxbuf, "open_beep") == 0)
            {
               BEEP_ON();
            }
            else if(strcmp((char *)wifi_rxbuf, "close_beep") == 0)
            {
               BEEP_OFF();
            }
            else if(strcmp((char *)wifi_rxbuf, "open_DHT11") == 0)
            {
                // 恢复温湿度读取的线程
                osThreadResume(DHT11TaskHandle);
		        		osThreadResume(WIFISendTaskHandle);
            }
            else if(strcmp((char *)wifi_rxbuf, "close_DHT11") == 0)
            {
		        		dht11_data.temperature = 0;
	         			dht11_data.humidity = 0;
                  // 挂起温湿度读取的线程
                osThreadSuspend(DHT11TaskHandle);
							  osThreadSuspend(WIFISendTaskHandle);
							  
            }
			      else if(strcmp((char *)wifi_rxbuf, "open_light") == 0)
            {
								osThreadResume(WIFISendTaskHandle);
                osThreadResume(LightTaskHandle);
            }
            else if(strcmp((char *)wifi_rxbuf, "close_light") == 0)
            {
                osThreadSuspend(LightTaskHandle);
								osThreadSuspend(WIFISendTaskHandle);
            }
            else if(strcmp((char *)wifi_rxbuf, "reset_all") == 0)
            {
                LED0_OFF();
								LED1_OFF();
								LED2_OFF();
								BEEP_OFF();
                osThreadSuspend(DHT11TaskHandle);
							  osThreadSuspend(WIFIRecTaskHandle);
								osThreadSuspend(LightTaskHandle);
							
            }
            memset(wifi_rxbuf, 0, sizeof(wifi_rxbuf));
  }
}
  /* USER CODE END StartWIFIRecTask */
}

/* USER CODE BEGIN Header_StartDHT11Task */
/**
* @brief Function implementing the DHT11Task thread.
* @param argument: Not used
* @retval None
*/
/* USER CODE END Header_StartDHT11Task */
void StartDHT11Task(void const * argument)
{
  /* USER CODE BEGIN StartDHT11Task */
  /* Infinite loop */
	dht11_data.humidity=0;
	dht11_data.temperature=0;
	osThreadSuspend(DHT11TaskHandle);
  for(;;)
  {
		osDelay(2500);
    if(DHT11_Read_TempAndHumidity(&dht11_data)==SUCCESS)
		{
			printf("成功读取温湿度信息\r\n");
		}
		else
		{
			printf("读取温湿度失败\r\n");
		}
  }
  /* USER CODE END StartDHT11Task */
}


/* USER CODE BEGIN Header_StarLightTask */
/**
* @brief Function implementing the LightTask thread.
* @param argument: Not used
* @retval None
*/
/* USER CODE END Header_StarLightTask */
void StarLightTask(void const * argument)
{
  /* USER CODE BEGIN StarLightTask */
  /* Infinite loop */
	adc_val=0;
	osThreadSuspend(LightTaskHandle);
  for(;;)
  {
    HAL_ADC_Start(&hadc1);
		if(HAL_ADC_PollForConversion(&hadc1,200)==HAL_OK)
		{
			adc_val=HAL_ADC_GetValue(&hadc1)*(3300.0/4096.0);
			printf("成功获取环境光信息\r\n");
		}
		else
		{
			printf("读取光敏电阻失败\r\n");
		}
		osDelay(2600);
		HAL_ADC_Stop(&hadc1);
		osDelay(100);
  }
  /* USER CODE END StarLightTask */
}

/* Private application code --------------------------------------------------*/
/* USER CODE BEGIN Application */

/* USER CODE END Application */

/************************ (C) COPYRIGHT STMicroelectronics *****END OF FILE****/
