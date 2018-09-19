CREATE TABLE todo(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  action VARCHAR (255),
  status_id INT,
  FOREIGN KEY (status_id) REFERENCES status(id),
  date DATE
)engine=InnoDB DEFAULT CHARSET=gbk;