new Splide('#book-slider', {
    perPage: 4,
    perMove: 1,
    gap: '0.5rem',
    breakpoints: {
        640: {
            perPage: 1,
        },
        768: {
            perPage: 2,
        },
        1024: {
            perPage: 3
        }
    },
}).mount();