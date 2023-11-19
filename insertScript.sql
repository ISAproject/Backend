INSERT INTO public.company(
    id, address, administrator_id, avg_grade, description, equipemnts_free_milliseconds, name)
VALUES 
    (1, '123 Main St', ARRAY[9,8], 4.5, 'A great company', ARRAY[1587781200000,1581289200000,1607132400000], 'Company A'),
    (2, '456 Oak St', ARRAY[10], 3.8, 'Providing quality services', ARRAY[1587781200000,1596357600000,1581289200000], 'Company B'),
    (3, '789 Pine St', ARRAY[11], 4.2, 'Innovative solutions', ARRAY[1698793200000,1700002800000,1700780400000,1698793200000,1698879600000], 'Company C'),
    (4, '101 Cedar St', ARRAY[12], 4.1, 'Excellence in every aspect', ARRAY[1581289200000,1596357600000,1607132400000], 'Company D'),
    (5, '202 Maple St', ARRAY[13], 3.9, 'Customer satisfaction is our priority', ARRAY[1596357600000], 'Company E');
