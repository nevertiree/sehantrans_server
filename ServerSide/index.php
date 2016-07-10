<?php
	session_start();

	require_once("/libs/mysql.function.php");

	$response_login=array();

	if (isset($_POST['user_name'])&&isset($_POST['user_password'])){
		$user_name = $_POST['user_name'];
		$user_password = $_POST['user_password'];
		connect_mysql();
	}

	if (is_exist_user($user_name,$user_password)){
		$response_login['success']=1;
		$response_login['message']="Login successfully!"
		echo json_encode($response_login);
		mysql_close();
	}
	else {
		$response_login['success']=0;
		$response_login['message']="Login failed!"
		echo json_encode($response_login);	
		mysql_close();
	}

?>

<!DOCTYPE html>
<html>
<head>
	<title>test</title>
</head>
<body>

<form method="POST" action="index.php">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="user_name"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="user_password"></td>
		</tr>

		<input type="submit" value="login" name="login">
	</table>
		
</form>

</body>
</html>