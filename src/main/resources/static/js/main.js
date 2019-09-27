var KTAppOptions = {
	"colors": {
		"state": {
			"brand": "#2c77f4",
			"light": "#ffffff",
			"dark": "#282a3c",
			"primary": "#5867dd",
			"success": "#34bfa3",
			"info": "#36a3f7",
			"warning": "#ffb822",
			"danger": "#fd3995"
		},
		"base": {
			"label": ["#c5cbe3", "#a1a8c3", "#3d4465", "#3e4466"],
			"shape": ["#f0f3ff", "#d9dffa", "#afb4d4", "#646c9a"]
		}
	}
};


//Filtro da Busca
$(function() {
  $('.filtro').on( function(e) {
      e.preventDefault();
    
      var filterValue = $(this).attr('data-filter');
    
      if(filterValue == "all") {
        $(".lista .lista").fadeIn('slow');
      } else {
        $(".lista .lista").not("." + filterValue).hide();
        $("." + filterValue).fadeIn('slow');
      }
    
      $('.filtro tr').removeClass('active');
      $(this).closest('tr').addClass('active');
    
      $('.no-result').hide();$('#input-busca').val('');
  });
  
  var rows = $('.lista tr');
  $('.no-result').hide();
  
  $('#input-busca').keyup(function() {
      $('.filtro tr').removeClass('active');
    
      var val = '^(?=.*\\b' + $.trim($(this).val()).split(/\s+/).join('\\b)(?=.*\\b') + ').*$',
      reg = RegExp(val, 'i'),
      text;

      rows.show().filter(function() {
        text = $(this).text().replace(/\s+/g, ' ');
        return !reg.test(text);
      }).hide();

      var visible = $('.lista:visible').length;

      if(visible == 0) { 
        $('.no-result').show();
      } else { 
        $('.no-result').hide();
      }

  });
  
});