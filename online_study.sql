/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : online_study

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 10/02/2022 19:16:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `admin_id` int(9) NOT NULL,
  `admin_pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cha_vid
-- ----------------------------
DROP TABLE IF EXISTS `cha_vid`;
CREATE TABLE `cha_vid`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cha_id` int(9) NOT NULL,
  `vid_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cha_vid
-- ----------------------------
INSERT INTO `cha_vid` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `cha_id` int(9) NOT NULL AUTO_INCREMENT,
  `cha_seq` int(2) NOT NULL,
  `cha_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cha_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES (1, 2, 'java程序设计');
INSERT INTO `chapter` VALUES (2, 1, 'c++程序设计');

-- ----------------------------
-- Table structure for cla_cou
-- ----------------------------
DROP TABLE IF EXISTS `cla_cou`;
CREATE TABLE `cla_cou`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_id` int(9) NOT NULL,
  `cou_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cla_cou
-- ----------------------------
INSERT INTO `cla_cou` VALUES (1, 10000, 100000000);
INSERT INTO `cla_cou` VALUES (2, 10000, 100000001);

-- ----------------------------
-- Table structure for cla_stu
-- ----------------------------
DROP TABLE IF EXISTS `cla_stu`;
CREATE TABLE `cla_stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_id` int(5) NOT NULL,
  `stu_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cla_stu
-- ----------------------------
INSERT INTO `cla_stu` VALUES (1, 10000, 120210101);
INSERT INTO `cla_stu` VALUES (2, 10001, 120210102);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cla_id` int(4) NOT NULL,
  `cla_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cla_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (10000, '计科1805');
INSERT INTO `class` VALUES (10001, '计科1804');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `com_id1` int(9) NOT NULL AUTO_INCREMENT COMMENT '评论的唯一ID',
  `com_id2` int(9) DEFAULT NULL COMMENT '该条评论回复的评论ID,空即表示该条评论为第一条评论',
  `com_uid` int(9) NOT NULL COMMENT '评论所属的用户',
  `com_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `com_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的日期',
  PRIMARY KEY (`com_id1`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, NULL, 120210101, 'gsfsfgd', '2022-02-10 17:07:04');
INSERT INTO `comment` VALUES (2, 1, 120210101, 'gsfgsgfsretw', '2022-02-10 17:07:14');
INSERT INTO `comment` VALUES (3, NULL, 120210101, 'xiete', '2022-02-10 17:07:30');
INSERT INTO `comment` VALUES (4, NULL, 120210101, '我草了你个dj', '2022-02-10 17:08:18');
INSERT INTO `comment` VALUES (5, 4, 120210101, '傻逼', '2022-02-10 17:08:27');

-- ----------------------------
-- Table structure for cou_cha
-- ----------------------------
DROP TABLE IF EXISTS `cou_cha`;
CREATE TABLE `cou_cha`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cou_id` int(9) NOT NULL,
  `cha_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cou_cha
-- ----------------------------
INSERT INTO `cou_cha` VALUES (1, 100000000, 1);
INSERT INTO `cou_cha` VALUES (2, 100000000, 2);

-- ----------------------------
-- Table structure for cou_mat
-- ----------------------------
DROP TABLE IF EXISTS `cou_mat`;
CREATE TABLE `cou_mat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cou_id` int(9) NOT NULL,
  `mat_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cou_mat
-- ----------------------------
INSERT INTO `cou_mat` VALUES (1, 100000000, 1);
INSERT INTO `cou_mat` VALUES (2, 100000000, 2);
INSERT INTO `cou_mat` VALUES (3, 100000000, 3);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cou_id` int(9) NOT NULL,
  `cou_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cou_tea_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cou_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cou_hour` tinyint(2) NOT NULL,
  `cou_cover_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cou_state` tinyint(1) NOT NULL COMMENT '1代表进行中,0代表已结课',
  PRIMARY KEY (`cou_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (100000000, 'Java程序设计语言', '张年如', '学习java语言可以让你快速掌握程序开发技能bbbfafafe11321321ba八佰伴阀安格让他个人其他感叹地方阿尔供热噶更让人去啊噶啥都干如果我好热听我说挂私人会所更好玩撒然后输入和时候更好是否合适生活上', 48, '/static/images/course_cover/1.jpg', 1);
INSERT INTO `course` VALUES (100000001, 'javaweb程序设计', '裴冬菊', '学习javaweb程序设计语言可以让你快速掌握网络开发', 48, '/static/images/course_cover/1.jpg', 1);

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `mat_id` int(9) NOT NULL,
  `mat_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mat_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mat_size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mat_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mat_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, '1.txt', '/static/upload/materials/100000000/1.txt', '1MB', '2021-01-01 00:00:00');
INSERT INTO `material` VALUES (2, '2.txt', '/static/upload/materials/100000000/2.txt', '2MB', '2021-01-01 00:00:00');
INSERT INTO `material` VALUES (3, '3.txt', '/static/upload/materials/100000000/3.txt', '3MB', '2021-01-01 00:00:00');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(9) NOT NULL,
  `notice_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `que_id` int(9) NOT NULL AUTO_INCREMENT,
  `que_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_item_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_item_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_item_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_item_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_ans` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `que_score` tinyint(2) NOT NULL DEFAULT 5,
  PRIMARY KEY (`que_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `sch_id` int(5) NOT NULL,
  `sch_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sch_img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (10410, '江西农业大学', '/static/images/school_badge/10410.jpg');

-- ----------------------------
-- Table structure for school_class
-- ----------------------------
DROP TABLE IF EXISTS `school_class`;
CREATE TABLE `school_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sch_id` int(5) NOT NULL,
  `cla_id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school_class
-- ----------------------------
INSERT INTO `school_class` VALUES (1, 10410, 10000);
INSERT INTO `school_class` VALUES (2, 10410, 10001);

-- ----------------------------
-- Table structure for school_tea
-- ----------------------------
DROP TABLE IF EXISTS `school_tea`;
CREATE TABLE `school_tea`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sch_id` int(9) NOT NULL,
  `tea_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school_tea
-- ----------------------------
INSERT INTO `school_tea` VALUES (1, 10410, 220210101);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score_sid` int(9) NOT NULL,
  `score_vid` int(9) NOT NULL,
  `score_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score_num` int(3) NOT NULL COMMENT '分数',
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(9) NOT NULL COMMENT '学号',
  `stu_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'md5加密后的字符串',
  `stu_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stu_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stu_sex` tinyint(1) DEFAULT NULL COMMENT '1表示男，2表示女, 0默认',
  `stu_state` tinyint(1) NOT NULL COMMENT '1表示正常,0表示禁用',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (120210101, 'e10adc3949ba59abbe56e057f20f883e', '林荣盛', '15907969536', '245603864@qq.com', 1, 1);
INSERT INTO `student` VALUES (120210102, '81dc9bdb52d04dc20036dbd8313ed055', '李云鹏', '15907960001', '1232@411', 1, 1);

-- ----------------------------
-- Table structure for tea_cou
-- ----------------------------
DROP TABLE IF EXISTS `tea_cou`;
CREATE TABLE `tea_cou`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(9) NOT NULL,
  `cou_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tea_id` int(9) NOT NULL,
  `tea_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'md5加密后的字符串',
  `tea_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tea_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tea_sex` tinyint(1) DEFAULT NULL COMMENT '1表示男,2表示女,0表示默认',
  `tea_state` tinyint(1) NOT NULL COMMENT '1表示正常,0表示禁用',
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (220210101, '202cb962ac59075b964b07152d234b70', '张年如', '15270969031', '99999999@qq.com', 1, 1);

-- ----------------------------
-- Table structure for vid_com
-- ----------------------------
DROP TABLE IF EXISTS `vid_com`;
CREATE TABLE `vid_com`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vid_id` int(9) NOT NULL,
  `com_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vid_com
-- ----------------------------
INSERT INTO `vid_com` VALUES (1, 1, 1);
INSERT INTO `vid_com` VALUES (2, 1, 2);
INSERT INTO `vid_com` VALUES (3, 1, 3);
INSERT INTO `vid_com` VALUES (4, 1, 4);
INSERT INTO `vid_com` VALUES (5, 1, 5);

-- ----------------------------
-- Table structure for vid_que
-- ----------------------------
DROP TABLE IF EXISTS `vid_que`;
CREATE TABLE `vid_que`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vid_id` int(9) NOT NULL,
  `que_id` int(9) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `vid_id` int(9) NOT NULL AUTO_INCREMENT,
  `vid_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vid_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vid_cover_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频封面路径,为空表示使用默认图片',
  `vid_up_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`vid_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 'java视频1-java的发展史', '/static/upload/videos/1.mp4', '/', '2021-01-01 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
