/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.31-log : Database - MyBlog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`MyBlog` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `MyBlog`;

/*Table structure for table `blogs` */

DROP TABLE IF EXISTS `blogs`;

CREATE TABLE `blogs` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` varchar(64) NOT NULL COMMENT '博客标题',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '博客发布时间',
  `content` varchar(2048) NOT NULL COMMENT '博客内容',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `blogs` */

insert  into `blogs`(`bid`,`title`,`time`,`content`) values (1,'这是一条测试博客','2020-10-20 15:50:28','这是一条测试博客'),(2,'这也是一条测试博客','2020-10-20 15:50:46','这也是一条测试博客');

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` varchar(2048) NOT NULL COMMENT '评论内容',
  `bid` int(11) NOT NULL COMMENT '评论对应博客id',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comments` */

insert  into `comments`(`cid`,`content`,`bid`) values (1,'这是一条测试评论',1),(2,'这也是一条测试评论',1);

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言id',
  `content` varchar(2048) NOT NULL COMMENT '留言内容',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `messages` */

insert  into `messages`(`mid`,`content`) values (1,'我喜欢你');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
