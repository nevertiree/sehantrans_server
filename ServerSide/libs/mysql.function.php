<?php
	function connect_mysql()
	{
		$mysql_server_name ='localhost';
		$mysql_username='root';
		$mysql_password='0512';
		$mysql_database='php_homework';
		//connect database
		$database_connect=mysql_connect($mysql_server_name,$mysql_username,$mysql_password);
		mysql_select_db($mysql_database);
		mysql_query("set names utf8");
	}
	
	function is_exist_name($username)
	{
		connect_mysql();
		$select_query= 'select * from user_security_info where user_name =\''.$username.'\';';
		$result=mysql_query($select_query);
		if (mysql_num_rows($result))
			return ture;
		else 
			return false;
		mysql_close($database_connect); 
	}
	
	function is_exist_user($username,$password)
	{
		connect_mysql();
		$select_query= 'select * from user_security_info where user_name =\''.$username.'\' and user_password = \''.$password.'\';';
		$result=mysql_query($select_query);
		if (mysql_num_rows($result))
		{
			return ture;
		}
		else 
			return false;
		mysql_close($database_connect); 
	}

	function is_exist_answer($username,$answer)
	{
		connect_mysql();
		$select_query= 'select * from user_security_info where user_name =\''.$username.'\' and user_security_answer = \''.$answer.'\';';
		$result=mysql_query($select_query);
		if (mysql_num_rows($result))
			return ture;
		else 
			return false;
		mysql_close($database_connect); 
	}


	function show_record()
	{
		connect_mysql();
		$select_query= 'select * from '.$tablename.' where user_name =\''.$username.'\';';
		//select user_name ,user_gender from user_private_info ,user_security_info where user_private_info.user_id=user_security_info.user_id;

		$result=mysql_query($select_query);
		mysql_close($database_connect); 

	}
	
	function delete_user($user_name)
	{
		connect_mysql();
		$select_query= 'delete from user_security_info where user_name =\''.$user_name.'\';';		
		$result_security=mysql_query($select_query);

		$select_query= 'delete from user_private_info where user_name =\''.$user_name.'\';';		
		$result_private=mysql_query($select_query);

		if ($result_private&&$result_security)
			return ture;
		else return false;
		mysql_close($database_connect); 
	}
?>