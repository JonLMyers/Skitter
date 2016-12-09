#!/bin/bash

MYSQL=`which mysql`

Q1 = "CREATE DATABASE  IF NOT EXISTS `accounts`;"
Q2 = "USE `accounts`;"

Q3 = "DROP TABLE IF EXISTS `role`;"
Q4 = "CREATE TABLE `role` (`id` int(11) NOT NULL AUTO_INCREMENT,`name` varchar(45) DEFAULT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;"

Q5 = "LOCK TABLES `role` WRITE;"
Q6 = "INSERT INTO `role` VALUES (1,'ROLE_USER');"
Q7 = "UNLOCK TABLES;"

Q8 = "DROP TABLE IF EXISTS `user`;"
Q9 = "CREATE TABLE `user` (`id` int(11) NOT NULL AUTO_INCREMENT,`screenName` VARCHAR (255) DEFAULT NULL,`username` varchar(255) DEFAULT NULL,`password` varchar(255) DEFAULT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;"

Q10 = "DROP TABLE IF EXISTS `user_role`;"
Q11 = "CREATE TABLE `user_role` (`user_id` int(11) NOT NULL,`role_id` int(11) NOT NULL,PRIMARY KEY (`user_id`,`role_id`),KEY `fk_user_role_roleid_idx` (`role_id`),CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=utf8;"

SQL="${Q1}${Q2}${Q3}${Q4}${Q5}${Q6}${Q7}${Q8}${Q9}${Q10}${Q11}"
$MYSQL -uroot -p -e "$SQL"
