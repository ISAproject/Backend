INSERT INTO public."user"(
    id, city, company_info, email, first_name, last_name, occupation, password, state, is_verified, tel_number, username, role)
VALUES 
    (-1, 'City0', 'Company Info 0', 'email0@example.com', 'First Name0', 'Last Name0', 'Occupation0', 'password0', 'State0', 'true','1234567890', 'username0', 0),
    (-2, 'City1', 'Company Info 1', 'email1@example.com', 'First Name1', 'Last Name1', 'Occupation1', 'password1', 'State1', 'true','1234567891', 'username1', 0),
    (-3, 'City2', 'Company Info 2', 'email2@example.com', 'First Name2', 'Last Name2', 'Occupation2', 'password2', 'State2', 'true','1234567892', 'username2', 0),
    (-4, 'City3', 'Company Info 3', 'email3@example.com', 'First Name3', 'Last Name3', 'Occupation3', 'password3', 'State3', 'true','1234567893', 'username3', 1),
    (-5, 'City4', 'Company Info 4', 'email4@example.com', 'First Name4', 'Last Name4', 'Occupation4', 'password4', 'State4', 'true','1234567894', 'username4', 1),
    (-6, 'City5', 'Company Info 5', 'email5@example.com', 'First Name5', 'Last Name5', 'Occupation5', 'password5', 'State5', 'true','1234567895', 'username5', 1),
    (-7, 'City6', 'Company Info 6', 'email6@example.com', 'First Name6', 'Last Name6', 'Occupation6', 'password6', 'State6','true', '1234567896', 'username6', 2),
    (-8, 'City7', 'Company Info 7', 'email7@example.com', 'First Name7', 'Last Name7', 'Occupation7', 'password7', 'State7', 'true','1234567897', 'username7', 2),
    (-9, 'City8', 'Company Info 8', 'email8@example.com', 'First Name8', 'Last Name8', 'Occupation8', 'password8', 'State8', 'true','1234567898', 'username8', 2),
    (-10, 'City10', 'Company Info 10', 'email10@example.com', 'First Name10', 'Last Name10', 'Occupation10', 'password10', 'State10', 'true',  '1234567890', 'username10', 2),
    (-11, 'City11', 'Company Info 11', 'email11@example.com', 'First Name11', 'Last Name11', 'Occupation11', 'password11', 'State11', 'true','1234567891', 'username11', 2),
    (-12, 'City12', 'Company Info 12', 'email12@example.com', 'First Name12', 'Last Name12', 'Occupation12', 'password12', 'State12','true', '1234567892', 'username12', 2),
    (-13, 'City13', 'Company Info 13', 'email13@example.com', 'First Name13', 'Last Name13', 'Occupation13', 'password13', 'State13', 'true','1234567893', 'username13', 2),
    (-14, 'City14', 'Company Info 14', 'email14@example.com', 'First Name14', 'Last Name14', 'Occupation14', 'password14', 'State14','true', '1234567894', 'username14', 2),
    (-15, 'City15', 'Company Info 15', 'email15@example.com', 'First Name15', 'Last Name15', 'Occupation15', 'password15', 'State15','true', '1234567895', 'username15', 2),
    (-16, 'City16', 'Company Info 16', 'email16@example.com', 'First Name16', 'Last Name16', 'Occupation16', 'password16', 'State16','true', '1234567896', 'username16', 2),
    (-17, 'City17', 'Company Info 17', 'email17@example.com', 'First Name17', 'Last Name17', 'Occupation17', 'password17', 'State17','true', '1234567897', 'username17', 2),
    (-18, 'City18', 'Company Info 18', 'email18@example.com', 'First Name18', 'Last Name18', 'Occupation18', 'password18', 'State18', 'true','1234567898', 'username81', 2),
    (-20, 'City20', 'Company Info 10', 'email10@example.com', 'First Name10', 'Last Name10', 'Occupation10', 'password10', 'State10', 'true',  '1234567890', 'username20', 0),
    (-21, 'City21', 'Company Info 11', 'email11@example.com', 'First Name11', 'Last Name11', 'Occupation11', 'password11', 'State11', 'false','1234567891', 'username21', 0),
    (-22, 'City22', 'Company Info 12', 'email12@example.com', 'First Name12', 'Last Name12', 'Occupation12', 'password12', 'State12','false', '1234567892', 'username22', 0),
    (-23, 'Grad', 'Company Info 13', 'example@example.com', 'First Name13', 'Last Name13', 'Occupation13', 'password13', 'State13', 'true','1234567893', 'username23', 0),
    (-24, 'Grad', 'Company Info 14', 'example@example.com', 'First Name14', 'Last Name14', 'Occupation14', 'password14', 'State14','true', '1234567894', 'username24', 1),
    (-25, 'Gradic', 'Company Info 15', 'example@example.com', 'First Name15', 'Last Name15', 'Occupation15', 'password15', 'State15','true', '1234567895', 'username25', 1),
    (-26, 'Gradic', 'Company Info 16', 'mail@example.com', 'First Name16', 'Last Name16', 'Occupation16', 'password16', 'State16','false', '1234567896', 'username26', 1),
    (-27, 'Gradic', 'Company Info 17', 'mail@example.com', 'First Name17', 'Last Name17', 'Occupation17', 'password17', 'State17','true', '1234567897', 'username77', 1),
	(-28, 'Grad', 'Company Info 18', 'mail@example.com', 'First Name18', 'Last Name18', 'Occupation18', 'password18', 'State18', 'false','1234567898', 'username29', 2);
    
INSERT INTO public.company(
	id, address, administrator_id, avg_grade, description, equipemnts_free_milliseconds, name)
VALUES 
    (-1, '123 Main St', ARRAY[-9,-8], 4.5, 'A great company', ARRAY[1587781200000,1581289200000,1607132400000], 'Company A'),
    (-2, '456 Oak St', ARRAY[-10], 3.8, 'Providing quality services', ARRAY[1587781200000,1596357600000,1581289200000], 'Company B'),
    (-3, '789 Pine St', ARRAY[-11], 4.2, 'Innovative solutions', ARRAY[1698793200000,1700002800000,1700780400000,1698879600000], 'Company C'),
    (-4, '101 Cedar St', ARRAY[-12], 4.1, 'Excellence in every aspect', ARRAY[1581289200000,1596357600000,1607132400000], 'Company D'),
    (-5, '202 Maple St', ARRAY[-13], 3.9, 'Customer satisfaction is our priority', ARRAY[1596357600000], 'Company E');
	
INSERT INTO public.equipment (
    id,
    company_id,
    description,
    grade,
    name,
    quantity,
    type
) VALUES
    (-1, -1, 'Medical Equipment 1', 4.5, 'Equipment A', 10, 0),
    (-2, -2, 'Medical Equipment 2', 3.8, 'Equipment B', 15, 1),
    (-3, -3, 'Medical Equipment 3', 4.2, 'Equipment C', 20, 2),
    (-4, -4, 'Medical Equipment 4', 3.5, 'Equipment D', 12, 3),
    (-5, -5, 'Medical Equipment 5', 4.0, 'Equipment E', 8, 0),
    (-6, -1, 'Medical Equipment 6', 3.9, 'Equipment F', 18, 1),
    (-7, -2, 'Medical Equipment 7', 4.1, 'Equipment G', 25, 2),
    (-8, -3, 'Medical Equipment 8', 3.7, 'Equipment H', 14, 3),
    (-9, -4, 'Medical Equipment 9', 4.3, 'Equipment I', 22, 0),
    (-10, -5, 'Medical Equipment 10', 3.6, 'Equipment J', 16, 1);
    