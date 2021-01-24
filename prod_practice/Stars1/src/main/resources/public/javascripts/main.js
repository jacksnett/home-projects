$(window).load(function(){



  var xhttpspeeds = new XMLHttpRequest();
    xhttpspeeds.open("GET", "/GetAllPlanetsSpeeds");
    xhttpspeeds.send();
    xhttpspeeds.onreadystatechange = function()
  {
      if(xhttpspeeds.status == 200 && xhttpspeeds.responseText != "") {
          var speeds = JSON.parse(xhttpspeeds.responseText);

          for (var key in speeds) {
              $("body").append("<style> .set-speed #" + key + " dl.infos dd:after {content: '" + speeds[key] + " km/h'; }</style>")
          }
      }
  }

    var xhttpCircumferences = new XMLHttpRequest();
    xhttpCircumferences.open("GET", "/GetAllCircumferences");
    xhttpCircumferences.send();
    xhttpCircumferences.onreadystatechange = function()
    {
        if(xhttpCircumferences.status == 200 && xhttpCircumferences.responseText != "") {
            var Circumferences = JSON.parse(xhttpCircumferences.responseText);

            for (var key in Circumferences) {
                $("body").append("<style> .set-size #" + key + " dl.infos dd:after {content: '" + Circumferences[key] + " km'; }</style>")
            }
        }
    }

    var xhttpDistances = new XMLHttpRequest();
    xhttpDistances.open("GET", "/GetAllDistances");
    xhttpDistances.send();
    xhttpDistances.onreadystatechange = function()
    {
        if(xhttpDistances.status == 200 && xhttpDistances.responseText != "") {
            var distances = JSON.parse(xhttpDistances.responseText);

            for (var key in distances) {
                $("body").append("<style> .set-distance #" + key + " dl.infos dd:after {content: '" + distances[key] + " km'; }</style>")
            }
        }
    }

  var body = $("body"),
      universe = $("#universe"),
      solarsys = $("#solar-system");

  var init = function() {
    body.removeClass('view-2D opening').addClass("view-3D").delay(2000).queue(function() {
      $(this).removeClass('hide-UI').addClass("set-speed");
      $(this).dequeue();
    });
  };

  var setView = function(view) { universe.removeClass().addClass(view); };

  $("#toggle-data").click(function(e) {
    body.toggleClass("data-open data-close");
    e.preventDefault();
  });

  $("#toggle-controls").click(function(e) {
    body.toggleClass("controls-open controls-close");
    e.preventDefault();
  });

  $("#data a").click(function(e) {
    var ref = $(this).attr("class");
    solarsys.removeClass().addClass(ref);
    $(this).parent().find('a').removeClass('active');
    $(this).addClass('active');
    e.preventDefault();
  });

  $(".set-view").click(function() { body.toggleClass("view-3D view-2D"); });
  $(".set-zoom").click(function() { body.toggleClass("zoom-large zoom-close"); });
  $(".set-speed").click(function() { setView("scale-stretched set-speed"); });
  $(".set-size").click(function() { setView("scale-s set-size"); });
  $(".set-distance").click(function() { setView("scale-d set-distance"); });

  init();

});