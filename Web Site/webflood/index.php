<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Savers - Flood Shield</title>
    <link rel="icon" href="save.png" />
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <script src="lib/jquery.js"></script>
<script src="d3.v3.min.js" language="JavaScript"></script>
    <script src="liquidFillGauge.js" language="JavaScript"></script>
    <style>
        .liquidFillGaugeText { font-family: Helvetica; font-weight: bold; }
    </style>
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="css/creative.min.css" rel="stylesheet">
    <style>
    .navbar-toggler {
        z-index: 1;
    }
    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }
    </style>
</head>
<body id="page-top">

    <nav class="navbar fixed-top navbar-toggleable-md navbar-light" id="mainNav">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            
            <div class="collapse navbar-collapse" id="navbarExample">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#device">Dévices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#services">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#news">News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="#device">Map <span class="badge badge-danger">1</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <header class="masthead" class="col-md-12">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading"><img class="img-responsive" src="nasa.png" /> Protect Our Earth !</h1>
                <hr>
                <p></p>
                <div class="row">
                
                <div class="col-md-offset-4 col-md-6">
                <!--<a href="https://floodmap.modaps.eosdis.nasa.gov/index.php">FloodMap</a> -->
                <a class="btn btn-primary btn-xl" href="#about">Show Device Informations</a>
                </div>
                </div>
                </div>
        </div>
        </div>
    </header>
    <section id="device">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading text-white">Dévices</h2>
                    <div align="center">
                    <div class="row">
<div class="col-md-4">
<?php

$ip = $_SERVER['REMOTE_ADDR']; // Recuperation de l'IP du visiteur
$query = @unserialize(file_get_contents('http://ip-api.com/php/'.$ip)); //connection au serveur de ip-api.com et recuperation des données
$meteo = @unserialize(file_get_contents('http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1'));
echo $meteo["main"]["temp"];
if($query && $query['status'] == 'success') 
{
    //code avec les variables
    $pays = strtolower(trim($query['country'])).".png";
    $pays = str_replace(' ','',$pays);
    $src = "flags/".$pays;
    echo "<img width=50 height=50 src=$src />  ".$query['country'] . "," . $query['city']."<br><br>";
}
?>
</div>
                    </div>
<div class="row"> 
<div class="col-md-2">
<strong>Water (Level)</strong>
<svg id="fillgauge1" width="97%" height="170"></svg>
</div>
<div class="col-md-2">
<strong>Oxygene (PPM)</strong>
<svg id="fillgauge2" width="97%" height="170"></svg>
</div>
<div class="col-md-2">
<strong>TDS (PPM)</strong>
<svg id="fillgauge3" width="97%" height="170"></svg>
</div>
<div class="col-md-2">
<strong>PH</strong>
<svg id="fillgauge4" width="97%" height="170"></svg>
</div>
<div class="col-md-4">
        <style>
        #map_canvas {
            height: 400px;
            
            
        }
        </style>
        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQgvIJq7ypJQky4UL1umwuPHizGkrSRY4&callback=initialize">
</script>
        <script>
     function initialize() {
        var lat = "<?php echo $query['lat'] ?>";
var long = "<?php echo $query['lon'] ?>";
    var styles = {
        'monTheme': [
        {
            featureType: 'road',
            stylers: [
                {visibility: 'off'}
            ]
        },
        {
            featureType: 'road.arterial',
            stylers: [
                {visibility: 'off'}
            ]
        },
        {
            featureType: 'road.local',
            stylers: [
                {visibility: 'off'}
            ]
        },
        {
            featureType: 'landscape',
            stylers: [
                {visibility: 'off'}
            ]
        },
        {
            featureType: 'water',
            stylers: [
                {visibility: 'on'},
                {lightness: -100 }
            ]
        }
    ]};

    var mapOptions = {
        zoom: 6,
        center: new google.maps.LatLng(lat,long),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        disableDefaultUI: true,
        mapTypeId: 'monTheme'
    }
    var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
    var styledMapType = new google.maps.StyledMapType(styles['monTheme'], {name: 'monTheme'});
    map.mapTypes.set('monTheme', styledMapType);

    var optionsCircle = {
        center: new google.maps.LatLng(lat,long),
        map: map,
        radius: 0,
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 4,
        fillColor: '#FF0000',
        fillOpacity: 0.35
    }
    var myCircle = new google.maps.Circle(optionsCircle);
    var optionsCircle2 = {
        center: new google.maps.LatLng(32.468601226807,2.8289000988007),
        map: map,
        radius: 0,
        strokeColor: '#8dc710',
        strokeOpacity: 0.8,
        strokeWeight: 4,
        fillColor: '#8dc710',
        fillOpacity: 0.35
    }
    var myCircle2 = new google.maps.Circle(optionsCircle2);
    var optionsCircle3 = {
        center: new google.maps.LatLng(35.468601226807,2.8289000988007),
        map: map,
        radius: 0,
        strokeColor: '#8dc710',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#8dc710',
        fillOpacity: 0.35
    }
    var myCircle3 = new google.maps.Circle(optionsCircle3);
        var optionsCircle4 = {
        center: new google.maps.LatLng(36.779588, -119.420282),
        map: map,
        radius: 0,
        strokeColor: '#8dc710',
        strokeOpacity: 0.8,
        strokeWeight: 5,
        fillColor: '#8dc710',
        fillOpacity: 0.35
    }
    var myCircle4 = new google.maps.Circle(optionsCircle4);
       var optionsCircle5 = {
        center: new google.maps.LatLng(40.712784,-74.005941),
        map: map,
        radius: 0,
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 8,
        fillColor: '#FF0000',
        fillOpacity: 0.35
    }
    var myCircle5 = new google.maps.Circle(optionsCircle5);
        var optionsCircle6 = {
        center: new google.maps.LatLng(38.270695, -80.774224),
        map: map,
        radius: 0,
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 8,
        fillColor: '#FF0000',
        fillOpacity: 0.35
    }
    var myCircle6 = new google.maps.Circle(optionsCircle6);
    function agrandirCercle(objetCercle, rayonFinal){
        var rayon = 0;
        var ajoute = 1000;
        var delai = 20;
        function incremente(){
            objetCercle.setRadius(rayon);
            if(rayon<=rayonFinal){
                rayon=rayon+ajoute;
                setTimeout(incremente,delai);
            }else {
                rayon=0;
                setTimeout(incremente,delai);
            }
        };
        setTimeout(incremente,delai);
    }
    agrandirCercle(myCircle, 40000);
    agrandirCercle(myCircle2, 40000);
    agrandirCercle(myCircle3, 40000);
    agrandirCercle(myCircle4, 40000);
    agrandirCercle(myCircle5, 40000);
    agrandirCercle(myCircle6, 40000);
}
        </script>
        <div id="map_canvas"></div>
</div>
</div>
<?php
function device(){
$bdd = new PDO("mysql:host=localhost;dbname=water","root","");
$query = $bdd->query("SELECT * FROM devices");
$resultat = array();
if($row = $query->fetch()){
    $resultat[] = $row; 
}
return $resultat;
}
$devices = device();
foreach($devices as $device){
  ?>
<script language="JavaScript">
    var config1 = liquidFillGaugeDefaultSettings();
    var config2 = liquidFillGaugeDefaultSettings3();
    var config3 = liquidFillGaugeDefaultSettings2();
    var config4 = liquidFillGaugeDefaultSettings4();
    var gauge1 = loadLiquidFillGauge("fillgauge1","<?php echo $device['water_height']/5*100; ?>",config1);
    var gauge2 = loadLiquidFillGauge("fillgauge2","<?php echo $device['oxy_height']/10*100; ?>",config3);
    var gauge3 = loadLiquidFillGauge("fillgauge3","<?php echo $device['tds_height']/6*100; ?>",config2);
    var gauge4 = loadLiquidFillGauge("fillgauge4","<?php echo $device['ph_height']; ?>",config4);
</script>
<?php
}
?>

                    <a class="btn btn-default btn-xl sr-button" href="#services">Get Started!</a>
                </div>
            </div>
        </div><br>
        <div class="row">
        <div class="col-md-6">
                                              <div class="embed-responsive embed-responsive-16by9">
    <video controls loop class="embed-responsive-item">
        <source src="Composition1.mp4" type="video/mp4">
    </video>
</div>
</div>
<div class="col-md-6">
<div class="row">
<div class="col-md-12">
<center><a class="btn btn-default btn-xl"><i class="fa fa-globe"></i>  Check Nasa FloodMap</a></center>
</div>
</div>
<div class="row">
<div class="col-md-12">
<center>
<a href="https://floodmap.modaps.eosdis.nasa.gov"><img src="Global.png" class="img-responsive" /></a></center>
</div>
</div>
</div>
</div>
    </section>
    <section id="services">
        <div class="container">
        <div class="row">
        <div class="col-md-6">
        </div>
        </div>
            <div class="row">
                <div class="col-lg-12 text-center"><br>
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-thermometer-1 text-primary sr-icons"></i>
                        <h3>Valuable time</h3>
                        <p class="text-muted">Provide an atmost valuable time to act and prepare</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-paper-plane text-primary sr-icons"></i>
                        <h3>Efficient and smart</h3>
                        <p class="text-muted">Organisation and instructions made easy and fast</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-newspaper-o text-primary sr-icons"></i>
                        <h3>Warning in real time</h3>
                        <p class="text-muted">and in all differents ways</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-signal text-primary sr-icons"></i>
                        <h3>Detect Your Signal</h3>
                        <p class="text-muted">Fast Detect Signal</p>    
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="no-padding" id="news">
        <div class="container-fluid">
            <div class="row no-gutter popup-gallery">
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/in.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/in.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Japan
                                </div>
                                <div class="project-name">
                                    Tokyo
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/ind2.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/ind2.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    India Floods
                                </div>
                                <div class="project-name">
                                    Indiana
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/plui.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/plui.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    United Kingom
                                </div>
                                <div class="project-name">
                                   London
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/bb.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/bb.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    France
                                </div>
                                <div class="project-name">
                                    Paris
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/box.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/box.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Algeria
                                </div>
                                <div class="project-name">
                                    Bab el Oued
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box" href="img/portfolio/fullsize/d.jpg">
                        <img class="img-fluid" src="img/portfolio/thumbnails/d.jpg" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Spain
                                </div>
                                <div class="project-name">
                                Barcelona
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <div class="call-to-action bg-dark">
        <div class="container text-center">
        </div>
    </div>

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
                </div>
                <div class="col-lg-4 offset-lg-2 text-center">
                    <i class="fa fa-phone fa-3x sr-contact"></i>
                    <p>+213-664-06-9326</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                    <p><a href="mailto:saversteamofficial@gmail.com">saversteamofficial@gmail.com</a></p>
                </div>
            </div>
        </div>
    </section>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
    <script src="js/creative.min.js"></script>
</body>
</html>
