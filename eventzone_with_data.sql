--------------------------------------------------------
--  File created - wtorek-maj-19-2015   
--------------------------------------------------------
REM INSERTING into EVENTZONE.USERS
SET DEFINE OFF;
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('zuzanna','password','name','surname','email@email');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('bartek','bartek','bartek','bartek','bartek@bartek');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('user','password','user','user','user@user');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('zu','zuz','zu','zu','zu');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('zuss','zuss','zuss','zuss','zuss');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('zooo','zooo','zooo','zooo','hu@wy');
REM INSERTING into EVENTZONE.EVENTS
SET DEFINE OFF;
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE) values ('1','sting','zuzanna','wroclaw',to_date('15/09/11','RR/MM/DD'),to_date('15/04/08','RR/MM/DD'),'it will be awesome',null,null,null);
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE) values ('2','juwenalia','bartek','krakow',to_date('15/05/14','RR/MM/DD'),to_date('15/04/23','RR/MM/DD'),'have fun',null,null,null);
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE) values ('3','festiwal','user','warsaw',to_date('15/04/10','RR/MM/DD'),to_date('15/04/01','RR/MM/DD'),'sss',null,null,null);
REM INSERTING into EVENTZONE.TICKETS
SET DEFINE OFF;
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('1','20','150','1150');
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('2','10','0','20');
REM INSERTING into EVENTZONE.PARTICIPANTS
SET DEFINE OFF;
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('1','zuzanna','1','1150','1');
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('1','bartek','1','1150','2');
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('2','zuzanna','1','20','3');


