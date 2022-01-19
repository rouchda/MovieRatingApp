<#include "header.ftl">

<b>Welcome to our little demonstration on the VR Webapp</b><br><br>

<form method="POST" action="usergui?action=createUserProfile">
	<fieldset id="CreateUserProfile">
		<legend>Required Information</legend>
		<div>
			<label>User Name</label>
			<input type="text" name="username" id="?">
	    </div>

		<div>
			<label>Age</label>
			<input type="text" name="age" id="">
	    </div>

		<div>
			<label>Email</label>
			<input type="text" name="Email">
	    </div>
	</fieldset>
	<button type="submit" id="SelectMRAWebpage" name="SelectMRAWebpage" value="Submit">Submit!</button>
</form>
<#include "footer.ftl">