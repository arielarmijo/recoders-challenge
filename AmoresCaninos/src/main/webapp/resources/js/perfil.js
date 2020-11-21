$('document').ready(function () {
	
	var modifiers = ['badge-primary',
					 'badge-secondary',
					 'badge-success',
					 'badge-danger', 
					 'badge-warning',
					 'badge-info', 
					 'badge-light',
					 'badge-dark'];
	
	$( ".badge" ).each( function( index, element ) {
		console.log(index, element);
		var random = Math.floor(Math.random() * modifiers.length);
		element.classList.add(modifiers[random]);
	});
	
})