
--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
`profile_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`name`     int(11) 
,`surname`     VARCHAR(60) 
,`date_birth`     Date 
,`gender`     VARCHAR(60) 
,`tel`     VARCHAR(60) 
,`email`     VARCHAR(60) 
,`residence`     VARCHAR(60) 
,`image`     int(11) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
`account_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`username`     VARCHAR(60) 
,`password`     VARCHAR(60) 
,`account_category`     int(11) 
,`profile`     int(11) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `account_category`
--

CREATE TABLE IF NOT EXISTS `account_category` (
`account_category_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`name`     VARCHAR(60) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
`teacher_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`edu_level`     VARCHAR(60) 
,`specification`     VARCHAR(60) 
,`account`     int(11) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `chat`
--

CREATE TABLE IF NOT EXISTS `chat` (
`chat_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`subject`     int(11) 
,`message`     VARCHAR(60) 
,`account`     int(11) 
,`account_fro`     int(11) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
`subject_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`description`     VARCHAR(60) 
,`course`     int(11) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
`course_id`      int(11) AUTO_INCREMENT PRIMARY KEY 
,`course_title`     VARCHAR(60) 
  ) 
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

