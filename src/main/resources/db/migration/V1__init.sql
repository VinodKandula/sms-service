CREATE TABLE sms (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  phone_number varchar(100) not null,
  body varchar(255) not null,
  response varchar(255),
  request_number int,
  callback_url varchar(255),
  created_date long,
  modified_date long,
);
