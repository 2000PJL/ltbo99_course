/*
 Navicat Premium Data Transfer

 Source Server         : ltbo99_work
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : bookdata

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 04/01/2022 17:32:37
*/



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookdata
-- ----------------------------
DROP TABLE IF EXISTS `bookdata`;
CREATE TABLE `bookdata`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `supersonic` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '超声波测距，单位mm\r\n',
  `temp` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度',
  `hum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '湿度',
  `light` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '光照强度\r\n',
  `colltime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '采集时间',
  `address` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17303 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookdata
-- ----------------------------
INSERT INTO `bookdata` VALUES (1, '10', '100', '79', '56', '2022-01-04 16:15:40', NULL);
INSERT INTO `bookdata` VALUES (2, '10.1', '17', '69', '526', '2022-01-04 17:18:32', NULL);
INSERT INTO `bookdata` VALUES (3, '10.1', '17', '69', '526', '2022-01-04 17:18:33', NULL);
INSERT INTO `bookdata` VALUES (4, '10.1', '17', '69', '526', '2022-01-04 17:18:34', NULL);
INSERT INTO `bookdata` VALUES (5, '10.1', '17', '69', '526', '2022-01-04 17:18:34', NULL);
INSERT INTO `bookdata` VALUES (6, '10.1', '17', '69', '526', '2022-01-04 17:18:36', NULL);
INSERT INTO `bookdata` VALUES (7, '10.1', '17', '69', '526', '2022-01-04 17:18:37', NULL);
INSERT INTO `bookdata` VALUES (8, '10.1', '17', '69', '526', '2022-01-04 17:18:38', NULL);
INSERT INTO `bookdata` VALUES (9, '10.1', '17', '69', '526', '2022-01-04 17:18:40', NULL);
INSERT INTO `bookdata` VALUES (10, '10.1', '17', '69', '526', '2022-01-04 17:18:41', NULL);
INSERT INTO `bookdata` VALUES (11, '10.1', '17', '69', '526', '2022-01-04 17:18:42', NULL);
INSERT INTO `bookdata` VALUES (12, '10.1', '17', '69', '526', '2022-01-04 17:18:43', NULL);
INSERT INTO `bookdata` VALUES (13, '51', '35', '89', '576', '2022-01-04 17:19:20', NULL);
INSERT INTO `bookdata` VALUES (14, '51', '35', '89', '576', '2022-01-04 17:19:21', NULL);
INSERT INTO `bookdata` VALUES (15, '10.1', '17', '69', '526', '2022-01-04 17:19:22', NULL);
INSERT INTO `bookdata` VALUES (16, '51', '35', '89', '576', '2022-01-04 17:19:23', NULL);
INSERT INTO `bookdata` VALUES (17, '51', '35', '89', '576', '2022-01-04 17:19:24', NULL);
INSERT INTO `bookdata` VALUES (18, '51', '35', '89', '576', '2022-01-04 17:19:25', NULL);
INSERT INTO `bookdata` VALUES (19, '10.1', '17', '69', '526', '2022-01-04 17:19:26', NULL);
INSERT INTO `bookdata` VALUES (20, '10.1', '17', '69', '526', '2022-01-04 17:19:27', NULL);
INSERT INTO `bookdata` VALUES (21, '51', '35', '89', '576', '2022-01-04 17:19:28', NULL);
INSERT INTO `bookdata` VALUES (22, '10.1', '17', '69', '526', '2022-01-04 17:19:29', NULL);
INSERT INTO `bookdata` VALUES (23, '10.1', '17', '69', '526', '2022-01-04 17:19:30', NULL);
INSERT INTO `bookdata` VALUES (24, '51', '35', '89', '576', '2022-01-04 17:19:32', NULL);
INSERT INTO `bookdata` VALUES (25, '10.1', '17', '69', '526', '2022-01-04 17:19:33', NULL);
INSERT INTO `bookdata` VALUES (26, '10.1', '17', '69', '526', '2022-01-04 17:19:34', NULL);
INSERT INTO `bookdata` VALUES (27, '51', '35', '89', '576', '2022-01-04 17:19:35', NULL);
INSERT INTO `bookdata` VALUES (28, '51', '35', '89', '576', '2022-01-04 17:19:36', NULL);
INSERT INTO `bookdata` VALUES (29, '10.1', '17', '69', '526', '2022-01-04 17:19:37', NULL);
INSERT INTO `bookdata` VALUES (30, '10.1', '17', '69', '526', '2022-01-04 17:19:38', NULL);
INSERT INTO `bookdata` VALUES (31, '51', '35', '89', '576', '2022-01-04 17:19:38', NULL);
INSERT INTO `bookdata` VALUES (32, '51', '35', '89', '576', '2022-01-04 17:19:39', NULL);
INSERT INTO `bookdata` VALUES (33, '10.1', '17', '69', '526', '2022-01-04 17:19:40', NULL);
INSERT INTO `bookdata` VALUES (34, '10.1', '17', '69', '526', '2022-01-04 17:19:41', NULL);
INSERT INTO `bookdata` VALUES (35, '51', '35', '89', '576', '2022-01-04 17:19:42', NULL);
INSERT INTO `bookdata` VALUES (36, '51', '35', '89', '576', '2022-01-04 17:19:43', NULL);
INSERT INTO `bookdata` VALUES (37, '10.1', '17', '69', '526', '2022-01-04 17:19:44', NULL);
INSERT INTO `bookdata` VALUES (38, '10.1', '17', '69', '526', '2022-01-04 17:19:44', NULL);
INSERT INTO `bookdata` VALUES (39, '51', '35', '89', '576', '2022-01-04 17:19:45', NULL);
INSERT INTO `bookdata` VALUES (40, '10.1', '17', '69', '526', '2022-01-04 17:20:58', NULL);
INSERT INTO `bookdata` VALUES (41, '31', '30', '89', '776', '2022-01-04 17:21:26', NULL);
INSERT INTO `bookdata` VALUES (42, '31', '30', '89', '776', '2022-01-04 17:21:27', NULL);
INSERT INTO `bookdata` VALUES (43, '10.1', '17', '69', '526', '2022-01-04 17:21:28', NULL);
INSERT INTO `bookdata` VALUES (44, '10.1', '17', '69', '526', '2022-01-04 17:21:29', NULL);
INSERT INTO `bookdata` VALUES (45, '31', '30', '89', '776', '2022-01-04 17:21:30', NULL);
INSERT INTO `bookdata` VALUES (46, '31', '30', '89', '776', '2022-01-04 17:21:31', NULL);
INSERT INTO `bookdata` VALUES (47, '10.1', '17', '69', '526', '2022-01-04 17:21:32', NULL);
INSERT INTO `bookdata` VALUES (48, '51', '35', '89', '576', '2022-01-04 17:22:31', NULL);
INSERT INTO `bookdata` VALUES (49, '31', '30', '89', '776', '2022-01-04 17:22:32', NULL);
INSERT INTO `bookdata` VALUES (50, '31', '30', '89', '776', '2022-01-04 17:22:33', NULL);
INSERT INTO `bookdata` VALUES (51, '51', '35', '89', '576', '2022-01-04 17:22:34', NULL);
INSERT INTO `bookdata` VALUES (52, '10.1', '17', '69', '526', '2022-01-04 17:22:35', NULL);
INSERT INTO `bookdata` VALUES (53, '10.1', '17', '69', '526', '2022-01-04 17:22:36', NULL);
INSERT INTO `bookdata` VALUES (54, '10.1', '17', '69', '526', '2022-01-04 17:22:37', NULL);
INSERT INTO `bookdata` VALUES (55, '10.1', '17', '69', '526', '2022-01-04 17:22:38', NULL);
INSERT INTO `bookdata` VALUES (56, '10.1', '17', '69', '526', '2022-01-04 17:22:39', NULL);
INSERT INTO `bookdata` VALUES (57, '31', '30', '89', '776', '2022-01-04 17:22:44', NULL);
INSERT INTO `bookdata` VALUES (58, '31', '30', '89', '776', '2022-01-04 17:22:45', NULL);
INSERT INTO `bookdata` VALUES (59, '31', '30', '89', '776', '2022-01-04 17:22:46', NULL);
INSERT INTO `bookdata` VALUES (60, '10.1', '17', '69', '526', '2022-01-04 17:22:47', NULL);
INSERT INTO `bookdata` VALUES (61, '10.1', '17', '69', '526', '2022-01-04 17:22:47', NULL);
INSERT INTO `bookdata` VALUES (62, '10.1', '17', '69', '526', '2022-01-04 17:22:48', NULL);
INSERT INTO `bookdata` VALUES (63, '10.1', '17', '69', '526', '2022-01-04 17:22:50', NULL);
INSERT INTO `bookdata` VALUES (64, '10.1', '17', '69', '526', '2022-01-04 17:22:51', NULL);
INSERT INTO `bookdata` VALUES (65, '51', '35', '89', '576', '2022-01-04 17:24:22', NULL);
INSERT INTO `bookdata` VALUES (66, '10.1', '17', '69', '526', '2022-01-04 17:24:23', NULL);
INSERT INTO `bookdata` VALUES (67, '31', '30', '89', '776', '2022-01-04 17:24:24', NULL);
INSERT INTO `bookdata` VALUES (68, '10.1', '17', '69', '526', '2022-01-04 17:24:25', NULL);
INSERT INTO `bookdata` VALUES (69, '10.1', '17', '69', '526', '2022-01-04 17:24:26', NULL);
INSERT INTO `bookdata` VALUES (70, '51', '35', '89', '576', '2022-01-04 17:24:27', NULL);
INSERT INTO `bookdata` VALUES (71, '51', '35', '89', '576', '2022-01-04 17:24:28', NULL);
INSERT INTO `bookdata` VALUES (72, '51', '35', '89', '576', '2022-01-04 17:24:28', NULL);
INSERT INTO `bookdata` VALUES (73, '31', '30', '89', '776', '2022-01-04 17:24:29', NULL);
INSERT INTO `bookdata` VALUES (74, '31', '30', '89', '776', '2022-01-04 17:24:30', NULL);
INSERT INTO `bookdata` VALUES (75, '31', '30', '89', '776', '2022-01-04 17:24:31', NULL);
INSERT INTO `bookdata` VALUES (76, '31', '30', '89', '776', '2022-01-04 17:24:32', NULL);
INSERT INTO `bookdata` VALUES (77, '31', '30', '89', '776', '2022-01-04 17:24:34', NULL);
INSERT INTO `bookdata` VALUES (78, '51', '35', '89', '576', '2022-01-04 17:24:35', NULL);
INSERT INTO `bookdata` VALUES (79, '51', '35', '89', '576', '2022-01-04 17:24:36', NULL);
INSERT INTO `bookdata` VALUES (80, '51', '35', '89', '576', '2022-01-04 17:24:37', NULL);
INSERT INTO `bookdata` VALUES (81, '51', '35', '89', '576', '2022-01-04 17:24:38', NULL);
INSERT INTO `bookdata` VALUES (82, '31', '30', '89', '776', '2022-01-04 17:24:39', NULL);
INSERT INTO `bookdata` VALUES (83, '31', '30', '89', '776', '2022-01-04 17:24:40', NULL);
INSERT INTO `bookdata` VALUES (84, '31', '30', '89', '776', '2022-01-04 17:24:41', NULL);
INSERT INTO `bookdata` VALUES (85, '31', '30', '89', '776', '2022-01-04 17:24:42', NULL);
INSERT INTO `bookdata` VALUES (86, '51', '35', '89', '576', '2022-01-04 17:27:59', NULL);
INSERT INTO `bookdata` VALUES (87, '31', '30', '89', '776', '2022-01-04 17:27:59', NULL);
INSERT INTO `bookdata` VALUES (88, '31', '30', '89', '776', '2022-01-04 17:28:00', NULL);
INSERT INTO `bookdata` VALUES (89, '31', '30', '89', '776', '2022-01-04 17:28:01', NULL);
INSERT INTO `bookdata` VALUES (90, '31', '30', '89', '776', '2022-01-04 17:28:01', NULL);
INSERT INTO `bookdata` VALUES (91, '31', '30', '89', '776', '2022-01-04 17:28:01', NULL);
INSERT INTO `bookdata` VALUES (92, '31', '30', '89', '776', '2022-01-04 17:28:01', NULL);
INSERT INTO `bookdata` VALUES (93, '31', '30', '89', '776', '2022-01-04 17:28:02', NULL);
INSERT INTO `bookdata` VALUES (94, '31', '30', '89', '776', '2022-01-04 17:28:02', NULL);
INSERT INTO `bookdata` VALUES (95, '51', '35', '89', '576', '2022-01-04 17:28:02', NULL);
INSERT INTO `bookdata` VALUES (96, '51', '35', '89', '576', '2022-01-04 17:28:02', NULL);
INSERT INTO `bookdata` VALUES (97, '10.1', '17', '69', '526', '2022-01-04 17:28:03', NULL);
INSERT INTO `bookdata` VALUES (98, '31', '30', '89', '776', '2022-01-04 17:28:03', NULL);
INSERT INTO `bookdata` VALUES (99, '10.1', '17', '69', '526', '2022-01-04 17:28:03', NULL);
INSERT INTO `bookdata` VALUES (100, '51', '35', '89', '576', '2022-01-04 17:28:03', NULL);
INSERT INTO `bookdata` VALUES (101, '10.1', '17', '69', '526', '2022-01-04 17:28:04', NULL);
INSERT INTO `bookdata` VALUES (102, '31', '30', '89', '776', '2022-01-04 17:28:04', NULL);
INSERT INTO `bookdata` VALUES (103, '31', '30', '89', '776', '2022-01-04 17:28:05', NULL);
INSERT INTO `bookdata` VALUES (104, '10.1', '17', '69', '526', '2022-01-04 17:28:05', NULL);
INSERT INTO `bookdata` VALUES (105, '51', '35', '89', '576', '2022-01-04 17:28:05', NULL);
INSERT INTO `bookdata` VALUES (106, '51', '35', '89', '576', '2022-01-04 17:28:06', NULL);
INSERT INTO `bookdata` VALUES (107, '51', '35', '89', '576', '2022-01-04 17:28:06', NULL);
INSERT INTO `bookdata` VALUES (108, '51', '35', '89', '576', '2022-01-04 17:28:06', NULL);
INSERT INTO `bookdata` VALUES (109, '31', '30', '89', '776', '2022-01-04 17:28:07', NULL);
INSERT INTO `bookdata` VALUES (110, '31', '30', '89', '776', '2022-01-04 17:28:07', NULL);
INSERT INTO `bookdata` VALUES (111, '31', '30', '89', '776', '2022-01-04 17:28:08', NULL);
INSERT INTO `bookdata` VALUES (112, '10.1', '17', '69', '526', '2022-01-04 17:28:08', NULL);
INSERT INTO `bookdata` VALUES (113, '31', '30', '89', '776', '2022-01-04 17:28:10', NULL);
INSERT INTO `bookdata` VALUES (114, '31', '30', '89', '776', '2022-01-04 17:28:10', NULL);
INSERT INTO `bookdata` VALUES (115, '51', '35', '89', '576', '2022-01-04 17:28:10', NULL);
INSERT INTO `bookdata` VALUES (116, '10.1', '17', '69', '526', '2022-01-04 17:28:11', NULL);
INSERT INTO `bookdata` VALUES (117, '31', '30', '89', '776', '2022-01-04 17:28:12', NULL);
INSERT INTO `bookdata` VALUES (118, '51', '35', '89', '576', '2022-01-04 17:28:12', NULL);
INSERT INTO `bookdata` VALUES (119, '10.1', '17', '69', '526', '2022-01-04 17:29:33', NULL);
INSERT INTO `bookdata` VALUES (120, '10.1', '17', '69', '526', '2022-01-04 17:29:34', NULL);
INSERT INTO `bookdata` VALUES (121, '10.1', '17', '69', '526', '2022-01-04 17:29:34', NULL);
INSERT INTO `bookdata` VALUES (122, '51', '35', '89', '576', '2022-01-04 17:29:34', NULL);
INSERT INTO `bookdata` VALUES (123, '31', '30', '89', '776', '2022-01-04 17:29:34', NULL);
INSERT INTO `bookdata` VALUES (124, '31', '30', '89', '776', '2022-01-04 17:29:34', NULL);
INSERT INTO `bookdata` VALUES (125, '10.1', '17', '69', '526', '2022-01-04 17:29:35', NULL);
INSERT INTO `bookdata` VALUES (126, '31', '30', '89', '776', '2022-01-04 17:29:35', NULL);
INSERT INTO `bookdata` VALUES (127, '31', '30', '89', '776', '2022-01-04 17:29:36', NULL);
INSERT INTO `bookdata` VALUES (128, '31', '30', '89', '776', '2022-01-04 17:29:36', NULL);
INSERT INTO `bookdata` VALUES (129, '31', '30', '89', '776', '2022-01-04 17:29:36', NULL);
INSERT INTO `bookdata` VALUES (130, '31', '30', '89', '776', '2022-01-04 17:29:36', NULL);
INSERT INTO `bookdata` VALUES (131, '31', '30', '89', '776', '2022-01-04 17:29:37', NULL);
INSERT INTO `bookdata` VALUES (132, '31', '30', '89', '776', '2022-01-04 17:29:37', NULL);
INSERT INTO `bookdata` VALUES (133, '91', '35', '89', '576', '2022-01-04 17:29:46', NULL);
INSERT INTO `bookdata` VALUES (134, '91', '35', '89', '576', '2022-01-04 17:29:46', NULL);
INSERT INTO `bookdata` VALUES (135, '91', '35', '89', '576', '2022-01-04 17:29:47', NULL);
INSERT INTO `bookdata` VALUES (136, '91', '35', '89', '576', '2022-01-04 17:29:47', NULL);
INSERT INTO `bookdata` VALUES (137, '31', '30', '89', '776', '2022-01-04 17:29:48', NULL);
INSERT INTO `bookdata` VALUES (138, '10.1', '17', '69', '526', '2022-01-04 17:29:49', NULL);
INSERT INTO `bookdata` VALUES (139, '91', '35', '89', '576', '2022-01-04 17:29:49', NULL);

SET FOREIGN_KEY_CHECKS = 1;
