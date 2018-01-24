CREATE TABLE sms (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  phone_number varchar(255) not null,
  body varchar(255) not null,
  response varchar(255) not null,
  request_number int,
  callback_url varchar(255) not null
);

INSERT INTO sms (phone_number, body, response, request_number, callback_url) VALUES ('+12012752759', 'Please response Yes or No.', '', '1', '');