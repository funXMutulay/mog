/**
 * 
 */

$('document').ready(function() {	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(mesure, status){
			$('#idEdit').val(mesure.id);
			$('#epaule').val(mesure.epaule);
			$('#manche').val(mesure.manche);
			$('#cou').val(mesure.cou);
			$('#buste').val(mesure.buste);
			$('#pantalon').val(mesure.pantalon);
			$('#mesure').val(mesure.hanche);
			$('#cuisse').val(mesure.cuisse);
			$('#tourtaille').val(mesure.tourtaille);
			$('#tourbuste').val(mesure.tourbuste);
			
			$('#boubou').val(invoice.boubou);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(mesure, status){
			$('#idDetails').val(mesure.id);
			$('#epauleDetails').val(mesure.epaule);
			$('#mancheDetails').val(mesure.manche);
			$('#couDetails').val(mesure.cou);
			$('#busteDetails').val(mesure.buste);
			$('#pantalonDetails').val(mesure.pantalon);
			$('#hancheDetails').val(mesure.hanche);
			$('#cuisseDetails').val(mesure.cuisse);
			$('#tourtailleDetails').val(mesure.tourtaille);
			$('#tourbusteDetails').val(mesure.tourbuste);
			$('#boubouDetails').val(mesure.boubou);
			$('#lastModifiedByDetails').val(invoice.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});