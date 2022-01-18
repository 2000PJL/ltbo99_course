/* USER CODE BEGIN Header */
/**
  ******************************************************************************
  * File Name          : freertos.c
  * Description        : Code for freertos applications
  ******************************************************************************
  * @attention
  *
  * <h2><center>&copy; Copyright (c) 2022 STMicroelectronics.
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
#include "ESP8266.h"
#include "hr04.h"
#include "cc2530.h"
#include "light.h"
#include "key.h"
#include "dht11.h"
#include "usart.h"


extern int key_value;
extern char rxBuff[];
extern uint8_t wifi_rxbuf[200];

char DHT11_buffer[128];
char blue_sendmsg[64];
char sendmsg1[64];
char cc2530_receivemsg[64];
double distance=0;

	
DHT11_Data_TypeDef DHT11_Data;


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
osThreadId MainTaskHandle;
osThreadId SensorTaskHandle;

/* Private function prototypes -----------------------------------------------*/
/* USER CODE BEGIN FunctionPrototypes */

/* USER CODE END FunctionPrototypes */

void StartMainTask(void const * argument);
void StartSensorTask(void const * argument);

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
  /* definition and creation of MainTask */
  osThreadDef(MainTask, StartMainTask, osPriorityBelowNormal, 0, 256);
  MainTaskHandle = osThreadCreate(osThread(MainTask), NULL);

  /* definition and creation of SensorTask */
  osThreadDef(SensorTask, StartSensorTask, osPriorityNormal, 0, 512);
  SensorTaskHandle = osThreadCreate(osThread(SensorTask), NULL);

  /* USER CODE BEGIN RTOS_THREADS */
  /* add threads, ... */
  /* USER CODE END RTOS_THREADS */

}

/* USER CODE BEGIN Header_StartMainTask */
/**
  * @brief  Function implementing the MainTask thread.
  * @param  argument: Not used
  * @retval None
  */
/* USER CODE END Header_StartMainTask */
void StartMainTask(void const * argument)
{
  /* USER CODE BEGIN StartMainTask */
	
  /* Infinite loop */
  for(;;)
  {
     osDelay(1799);
	  switch(key_value)
	  {
		  case 0: 
		  {
			  osThreadResume(SensorTaskHandle);
			  LED0_ON();
			  key_value=-1;
			  break;
		  }
		  case 1: 
		  {
			  osThreadSuspend(SensorTaskHandle);
			  LED0_OFF();
			  key_value=-1;
			  break;
		  }
	  }
	  printf("wifi接收到的数据为：%s\r\n",wifi_rxbuf);
	  
	  if(strcmp("OLED",(char *)wifi_rxbuf)==0)
	  {
		  LED2_ON();
		  cc2530_sendMessage("OL");
	  }else if(strcmp("CLED",(char *)wifi_rxbuf)==0)
	  {
		  LED2_OFF();
		  cc2530_sendMessage("CL");
		  
	  }else if(strcmp("OBEEP",(char *)wifi_rxbuf)==0)
	  {
		  BEEP_ON();
		  cc2530_sendMessage("OB");
	  }else if(strcmp("CBEEP",(char *)wifi_rxbuf)==0)
	  {
		  BEEP_OFF();
		  cc2530_sendMessage("CB");
	  }
	  
	  
	  get_cc2530Message(cc2530_receivemsg);
	  if(strlen(cc2530_receivemsg)!=2)
	  {
		  Wifi_SendData(cc2530_receivemsg);
		  printf("我发送的数据为：%s",cc2530_receivemsg);
	  }else{
			if(strcmp("OL",(char *)cc2530_receivemsg)==0)
			{
			  LED2_ON();
			}else if(strcmp("CL",(char *)cc2530_receivemsg)==0)
			{
			  LED2_OFF();
			}else if(strcmp("OB",(char *)cc2530_receivemsg)==0)
			{
			  BEEP_ON();
			}else if(strcmp("CB",(char *)cc2530_receivemsg)==0)
			{
			  BEEP_OFF();
			}
			memset(cc2530_receivemsg,0,200);
	  }
	 // memset(cc2530_receivemsg,0,200);
	  
	  
	  
  }
  /* USER CODE END StartMainTask */
}

/* USER CODE BEGIN Header_StartSensorTask */
/**
* @brief Function implementing the SensorTask thread.
* @param argument: Not used
* @retval None
*/
/* USER CODE END Header_StartSensorTask */
void StartSensorTask(void const * argument)
{
  /* USER CODE BEGIN StartSensorTask */
	osThreadSuspend(SensorTaskHandle);
  /* Infinite loop */
  for(;;)
  {
	DHT11_Read_TempAndHumidity(&DHT11_Data);
	osDelay(1000);
	distance=Hcsr04_StateRead();
	osDelay(1000);
	sprintf(sendmsg1,"##,%.2f,%d,%.1f,%.1f,$$",distance,get_light(),DHT11_Data.humidity,DHT11_Data.temperature);
	cc2530_sendMessage(sendmsg1);
	printf("cc2530 is %s",sendmsg1);
	 
  }
  /* USER CODE END StartSensorTask */
}

/* Private application code --------------------------------------------------*/
/* USER CODE BEGIN Application */

/* USER CODE END Application */

/************************ (C) COPYRIGHT STMicroelectronics *****END OF FILE****/
