CREATE TABLE todo(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  action VARCHAR (255),
  statusid INT,
  userid INT,
  FOREIGN KEY (statusid) REFERENCES status(id),
  date DATE,
  FOREIGN KEY (userid) REFERENCES user(id)
)engine=InnoDB DEFAULT CHARSET=gbk;