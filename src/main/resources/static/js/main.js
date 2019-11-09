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

//DragDrop do Kanban
var KTPortletDraggable = function () {

    return {
        //main function to initiate the module
        init: function () {
            $("#kt_sortable_portlets").sortable({
                connectWith: ".kt-portlet__head",
                items: ".kt-portlet",
                opacity: 0.8,
                handle : '.kt-portlet__head',
                coneHelperSize: true,
                placeholder: 'kt-portlet--sortable-placeholder',
                forcePlaceholderSize: true,
                tolerance: "pointer",
                helper: "clone",
                tolerance: "pointer",
                forcePlaceholderSize: !0,
                helper: "clone",
                cancel: ".kt-portlet--sortable-empty", // cancel dragging if portlet is in fullscreen mode
                revert: 250, // animation in milliseconds
                update: function(b, c) {
                    if (c.item.prev().hasClass("kt-portlet--sortable-empty")) {
                        c.item.prev().before(c.item);
                    }                    
                }
            });
        }
    };
}();

jQuery(document).ready(function() {
    KTPortletDraggable.init();
});

//Contador da page dashboard
var counter = document.querySelectorAll(".counter")

window.addEventListener("load", function() {
  counter.forEach(function(k, v) {
	  
	  var start = counter[v].getAttribute('data-count-start')
	  var end = counter[v].getAttribute('data-count-end')
	  var speed = counter[v].getAttribute('data-speed')

	  setInterval(function() {
		  start++;
		  if(start > end) {
			return false;
		  }
		  counter[v].innerText = start;

		}, speed)
  })
  
}, false)


// Google Chart
google.charts.load("current", {packages:["corechart"]});
		google.charts.setOnLoadCallback(drawChart);
		function drawChart() {
			var data = google.visualization.arrayToDataTable([
			['Language', 'Speakers (in millions)'],
			['Clientes Satisfeitos',  40],
			['Atividades Pendentes', 10],
			['Negócios Fechados',  30],
			['Negócios Perdidos', 20],
			]);

		var options = {
			legend: 'none',
			pieSliceText: 'none',
			pieStartAngle: 'none',
			colors: ['#005594',  '#f78b1f', '#109618', '#dc3912']
		};

			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			chart.draw(data, options);
		}