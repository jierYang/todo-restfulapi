CREATE TABLE todo(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  action VARCHAR (255),
  status_id INT,
  user_id INT,
  FOREIGN KEY (status_id) REFERENCES status(id),
  date DATE,
  FOREIGN KEY (user_id) REFERENCES users(id)
)engine=InnoDB DEFAULT CHARSET=gbk;