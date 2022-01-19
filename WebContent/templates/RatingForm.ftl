<#include "header.ftl">

<b>Welcome to our little demonstration on the VR Webapp</b><br><br>

<form method="POST" action="usergui?action=makeRating">
	<fieldset id="Rating">
		<legend>Required Information</legend>
		<div>
			<label>Movie Id</label>
			<input type="int" name="mId" id="?">
	    </div>

		<div>
			<label>Movie Rating</label>
			<input type="int" name="movieRating">
	    </div>
		<div>
			<label>Comment</label>
			<input type="text" name="comment">
	    </div>
	    <div>
	    	<label>User Name</label>
	    	<input type="text" name="name">
	    </div>
	    
	</fieldset>
	<input type="hidden" value="${mId}" name="mId">
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">