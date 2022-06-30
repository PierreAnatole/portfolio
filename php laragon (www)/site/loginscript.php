<?php
$pdo = require_once 'database-session.php';
$error = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
	$input = filter_input_array(INPUT_POST, [
		'login-email' => FILTER_SANITIZE_EMAIL,
	]);
	$password =$_POST['login-mdp'] ?? '';
	$email = $input['login-email'] ?? '';

	if (!$password || !$email) {
		$error = 'ERROR';
	}
	else {
		$statementUser = $pdo->prepare('SELECT * FROM user WHERE email = ?');
		$statementUser -> execute([$email]);
		$user = $statementUser->fetch();
		if (password_verify($password, $user['password'])) {
			$statementSession=$pdo->prepare('INSERT INTO session VALUES(DEFAULT, :userId)'); 
			$statementSession->bindValue(':userId', $user['id']);
			$statementSession->execute();
			$sessionId = $pdo->lastInsertId();
			setcookie('session', $sessionId, time() + 60 * 60 * 24 * 14, "","", false, true);
			header('Location: /profilevg.php');
		} else {
			$error = 'Identifiants invalides';
		}
	}
}
?>

<?php require_once 'espace-client.php'; ?>

<?php if ($error): ?>
        <h1 style="color:red;"> <?= $error ?> </h1>
<?php endif; ?>
