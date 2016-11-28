<%@include file="CommonHeader.jsp" %>






<div class="container">
  
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="max-width: 900px; margin: 0 auto;">

  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <div class="carousel-inner" role="listbox">
  
    <div class="item active">
<img class="img-responsive" src= "resources/tshirts.jpg"  >      
    </div>

    <div class="item">
<img class="img-responsive" src= "resources/keychains.png" >
    </div>
  
    <div class="item">
<img class="img-responsive" src= "resources/mugs.png" >
    </div>
    
    <div class="item">
<img class="img-responsive" src= "resources/cushion.png" >
    </div>
  </div>
  
  <a class="carousel-control left" href="#myCarousel" role="button" data-slide="prev">
    <span class="icon-prev" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control right" href="#myCarousel" role="button" data-slide="next">
    <span class="icon-next" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>

</div>
</div>

<%@include file="CommonFooter.jsp" %>