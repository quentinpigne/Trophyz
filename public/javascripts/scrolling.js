$(document).ready(function() {
    // Collapse header nav when scroll more than 50px
    $(window).scroll(function() {
        if ($(window).scrollTop() > 50 && $(window).width() >= 780) {
            $("header").addClass("collapsed");
        } else {
            $("header").removeClass("collapsed");
        }
    });

    // For each link which contains '#' in href attribute
    $('a[href*=#]').each(function() {
        // Check if location hostname/pathname and link hostname/pathname are equals and if the link contains '#'
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname && this.hash.replace(/#/,'') ) {
            // this.hash = #home | #blog | ...
            var $target = $(this.hash);
            if ($target) {
                var targetOffset = $target.offset().top;
                $(this).click(function() {
                    $(".nav a").removeClass("active");
                    $(this).addClass('active');
                    $('html, body').animate({scrollTop: targetOffset}, 1000);
                    return false; // Stop the link
                });
            }
        }
    });
});
