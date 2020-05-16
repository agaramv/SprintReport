-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: sprintreport
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `r_agile_team`
--

DROP TABLE IF EXISTS `r_agile_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_agile_team` (
  `team_id` varchar(5) NOT NULL COMMENT 'Team ID',
  `team_desc` varchar(45) NOT NULL COMMENT 'Team Description',
  `parent_team_id` varchar(5) DEFAULT NULL,
  `Project_ind` varchar(1) DEFAULT NULL,
  `scrum_master_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `team_id_UNIQUE` (`team_id`),
  KEY `scrum_master_idx` (`scrum_master_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_agile_team`
--

LOCK TABLES `r_agile_team` WRITE;
/*!40000 ALTER TABLE `r_agile_team` DISABLE KEYS */;
INSERT INTO `r_agile_team` VALUES ('ABIP','ABIP',NULL,NULL,NULL),('CACSG','Collections',NULL,NULL,NULL),('CR','Compliance Repository',NULL,NULL,NULL),('EFILE','eFile',NULL,NULL,NULL),('ENG','Engineering',NULL,NULL,NULL),('INT','Interface',NULL,NULL,NULL),('IOP','Individual Online Portal',NULL,'Y',NULL),('LIT','Legislative IMplementation',NULL,NULL,NULL),('PASS','PASS',NULL,NULL,NULL),('RA','Revenue Accounting','AR',NULL,NULL),('REO','Refunds and External Offset','AR',NULL,NULL),('REP','Reports',NULL,NULL,NULL),('RP','Returns Processing','AR',NULL,NULL),('SIEBE','Siebel',NULL,NULL,NULL),('TA','Taxpayer Accounting ','AR',NULL,NULL),('TAKFI','TACS and KFI',NULL,NULL,NULL),('TI','Taxpayer Information ','AR',NULL,NULL),('VFACT','Audit Workbench',NULL,'Y',NULL),('VTOL','Virginia Tax Online',NULL,NULL,NULL);
/*!40000 ALTER TABLE `r_agile_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_form_ui`
--

DROP TABLE IF EXISTS `r_form_ui`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_form_ui` (
  `version_num` int NOT NULL,
  `line_num` int NOT NULL,
  `active_ind` char(1) NOT NULL,
  `work_code` char(6) DEFAULT NULL,
  `work_desc` varchar(100) NOT NULL,
  `info_type` varchar(1) NOT NULL COMMENT 'D-Data, H-header, C-Calculation',
  `support_ind` char(1) DEFAULT NULL,
  `value_ind` char(1) DEFAULT NULL,
  `new_value_ind` char(1) DEFAULT NULL,
  `run_ind` char(1) DEFAULT NULL COMMENT 'Y-yes, N-No',
  `grow_ind` char(1) DEFAULT NULL,
  `transform_ind` char(1) DEFAULT NULL,
  `create_date` datetime NOT NULL COMMENT 'Date data create',
  `last_upd_date` datetime NOT NULL,
  PRIMARY KEY (`version_num`,`line_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_form_ui`
--

LOCK TABLES `r_form_ui` WRITE;
/*!40000 ALTER TABLE `r_form_ui` DISABLE KEYS */;
INSERT INTO `r_form_ui` VALUES (1,1,'Y','HEADER','Predictability - Sprint Completion','H',NULL,NULL,NULL,NULL,NULL,NULL,'2004-12-20 00:00:00','2004-12-20 00:00:00'),(1,2,'Y','PBIC','Originally Planned PBI - Completed','D',NULL,NULL,NULL,NULL,NULL,NULL,'2004-12-20 00:00:00','2004-12-20 00:00:00'),(1,3,'Y','PBINC','Originally Planned PBI - Not Completed','D',NULL,NULL,NULL,NULL,NULL,NULL,'2004-12-20 00:00:00','2004-12-20 00:00:00'),(1,4,'Y','BUGC','Originally Planned Bugs - Completed','D',NULL,NULL,NULL,NULL,NULL,NULL,'2004-12-20 00:00:00','2004-12-20 00:00:00'),(1,5,'Y','BUGNC','Originally Planned Bugs - Not Completed','D',NULL,NULL,NULL,NULL,NULL,NULL,'2004-12-20 00:00:00','2004-12-20 00:00:00'),(1,6,'Y','HEADER','Sprint Forecast Completion Percentage','C',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,7,'Y','ADDPBI','Add on PBIs','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,8,'Y','ADDBUG','Add on Bugs','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,9,'Y','HEADER','Reason if Sprint not Completed','H',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,10,'Y','R1','Team Over Committed','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,11,'Y','R2','Unplanned Activity','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,12,'Y','R3','Impediments or Dependency','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,13,'Y','R4','Emergency Production Issue','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,14,'Y','R5','Other ','D',NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,15,'Y','HEADER','Support vs New Value Creation','H','',NULL,NULL,NULL,NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,16,'Y','PRDBUG','Production Bugs','D','Y',NULL,NULL,'Y',NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,17,'Y','NOPRBG','Non-Production Bugs','D','Y',NULL,NULL,'Y',NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,18,'Y','PRDSUP','Production Support','D',NULL,'Y',NULL,'Y',NULL,NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,19,'Y','NVPBI','Non Support PBI','D',NULL,NULL,'Y',NULL,'Y',NULL,'2020-12-20 00:00:00','2020-12-20 00:00:00'),(1,20,'Y','INNOV','Automation and Process Improvement','D',NULL,NULL,'Y',NULL,NULL,'Y','2020-12-20 00:00:00','2020-12-20 00:00:00');
/*!40000 ALTER TABLE `r_form_ui` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_ot_request`
--

DROP TABLE IF EXISTS `r_ot_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_ot_request` (
  `category` varchar(3) NOT NULL,
  `request_id` varchar(6) NOT NULL,
  `request_short_desc` varchar(25) DEFAULT NULL,
  `request_desc` varchar(150) DEFAULT NULL,
  `date_started` date DEFAULT NULL,
  `date_completed` date DEFAULT NULL,
  `date_implemented` date DEFAULT NULL,
  `outcome` varchar(150) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`category`,`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_ot_request`
--

LOCK TABLES `r_ot_request` WRITE;
/*!40000 ALTER TABLE `r_ot_request` DISABLE KEYS */;
INSERT INTO `r_ot_request` VALUES ('OTR','123456',NULL,'Test1',NULL,NULL,NULL,'Test1','A'),('OTR','123457',NULL,'Test1',NULL,NULL,NULL,'Test1','A'),('OTR','123458',NULL,'Test1',NULL,NULL,NULL,'Test1','A');
/*!40000 ALTER TABLE `r_ot_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_reasons`
--

DROP TABLE IF EXISTS `r_reasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_reasons` (
  `code` varchar(3) NOT NULL,
  `reason_desc` varchar(45) DEFAULT NULL,
  `history_ind` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_reasons`
--

LOCK TABLES `r_reasons` WRITE;
/*!40000 ALTER TABLE `r_reasons` DISABLE KEYS */;
INSERT INTO `r_reasons` VALUES ('R01','Team Over Committed','N'),('R02','Unplanned Activity','N'),('R03','Impediments ','N'),('R04','Dependencies','N'),('R05','Production Issue','N');
/*!40000 ALTER TABLE `r_reasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_scrum_master`
--

DROP TABLE IF EXISTS `r_scrum_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_scrum_master` (
  `email` varchar(45) NOT NULL,
  `display_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_scrum_master`
--

LOCK TABLES `r_scrum_master` WRITE;
/*!40000 ALTER TABLE `r_scrum_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_scrum_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprint_report`
--

DROP TABLE IF EXISTS `sprint_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprint_report` (
  `team_id` varchar(5) NOT NULL,
  `sprint_num` int NOT NULL,
  `sprint_start_date` date NOT NULL,
  `sprint_end_date` date NOT NULL,
  `scrum_master_email` varchar(45) DEFAULT 'test@gmail.com',
  `planned_PBI_completed` int DEFAULT NULL,
  `planned_PBI_not_completed` int DEFAULT NULL,
  `planned_bug_completed` int DEFAULT '0',
  `planned_bug_not_completed` int DEFAULT '0',
  `Addon_PBI_completed` int DEFAULT NULL,
  `Addon_BUG_Completed` int DEFAULT NULL,
  `reason_1` varchar(45) DEFAULT NULL,
  `reason_2` varchar(45) DEFAULT NULL,
  `reason_3` varchar(45) DEFAULT NULL,
  `reason_4` varchar(45) DEFAULT NULL,
  `reason_5` varchar(45) DEFAULT NULL,
  `reason_other` varchar(45) DEFAULT NULL,
  `support` char(1) DEFAULT NULL,
  `improvement` char(1) DEFAULT NULL,
  `new_value` char(1) DEFAULT NULL,
  `run_ind` char(1) DEFAULT 'N',
  `grow_ind` char(1) DEFAULT 'N',
  `transform_ind` char(1) DEFAULT 'N',
  `sprint_capacity` int DEFAULT '0',
  `planned_capacity` int DEFAULT '0',
  `actual_capacity` int DEFAULT '0',
  `estimated_hours` int DEFAULT '0',
  `completed_hours` int DEFAULT '0',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_upd_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`team_id`,`sprint_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint_report`
--

LOCK TABLES `sprint_report` WRITE;
/*!40000 ALTER TABLE `sprint_report` DISABLE KEYS */;
INSERT INTO `sprint_report` VALUES ('RA',40,'2020-05-01','2020-05-10','fidel.rodriguez@tax.virginia.gov',20,4,3,0,0,0,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-01 00:00:00','2020-05-01 00:00:00'),('REO',26,'2020-03-14','2020-03-30','fidel.rodriguez@tax.virginia.gov',20,4,3,0,0,0,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-01 00:00:00','2020-05-01 00:00:00'),('REO',27,'2020-05-13','2020-05-29',NULL,20,4,3,0,0,0,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-01 00:00:00','2020-05-01 00:00:00'),('REO',28,'2020-05-13','2020-05-29','Test@gmail.com',20,4,3,0,8,1,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-04 00:00:00','2020-05-04 00:00:00'),('TA',32,'2020-04-01','2020-04-14','fidel.rodriguez@tax.virginia.gov',20,4,3,0,0,0,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-01 00:00:00','2020-05-01 00:00:00'),('TA',33,'2020-04-15','2020-04-30','fidel.rodriguez@tax.virginia.gov',20,4,3,0,0,0,'Unplanned Activity',NULL,NULL,NULL,NULL,'This is a test','0','0','0','N','N','N',100,100,100,0,0,'2020-05-01 00:00:00','2020-05-01 00:00:00');
/*!40000 ALTER TABLE `sprint_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprint_report_otrequest`
--

DROP TABLE IF EXISTS `sprint_report_otrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprint_report_otrequest` (
  `team_id` varchar(5) NOT NULL,
  `sprint_num` int NOT NULL,
  `category` varchar(3) DEFAULT NULL,
  `request_id` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`team_id`,`sprint_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint_report_otrequest`
--

LOCK TABLES `sprint_report_otrequest` WRITE;
/*!40000 ALTER TABLE `sprint_report_otrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `sprint_report_otrequest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-16 16:51:20
