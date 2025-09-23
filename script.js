(() => {
  const viewport = document.querySelector('.carousel-viewport');
  const track = document.querySelector('.carousel-track');
  const cards = Array.from(track.children);
  const prev = document.querySelector('.carousel-btn.prev');
  const next = document.querySelector('.carousel-btn.next');
  const dotsWrap = document.querySelector('.carousel-dots');

  // Crear los puntitos de navegación
  const dots = cards.map((_, i) => {
    const b = document.createElement('button');
    b.type = 'button';
    b.setAttribute('aria-label', 'Ir a la tarjeta ' + (i + 1));
    b.addEventListener('click', () => scrollToIndex(i));
    dotsWrap && dotsWrap.appendChild(b);
    return b;
  });

  // Calcula el ancho de cada tarjeta
  const slideWidth = () =>
    cards[0].getBoundingClientRect().width +
    parseFloat(getComputedStyle(track).gap || 0);

  function scrollBySlides(dir = 1) {
    viewport.scrollBy({ left: dir * slideWidth(), behavior: 'smooth' });
  }

  function scrollToIndex(i) {
    const x = i * slideWidth();
    viewport.scrollTo({ left: x, behavior: 'smooth' });
  }

  // Eventos de botones
  prev.addEventListener('click', () => scrollBySlides(-1));
  next.addEventListener('click', () => scrollBySlides(1));

  // Control con teclado
  viewport.addEventListener('keydown', (e) => {
    if (e.key === 'ArrowLeft') scrollBySlides(-1);
    if (e.key === 'ArrowRight') scrollBySlides(1);
  });

  // Actualiza los puntitos según el slide visible
  const io = new IntersectionObserver(
    (entries) => {
      let current = 0;
      entries.forEach((en) => {
        if (en.isIntersecting) current = cards.indexOf(en.target);
      });
      dots.forEach((d, i) =>
        d.setAttribute('aria-current', i === current)
      );
    },
    { root: viewport, threshold: 0.6 }
  );

  cards.forEach((c) => io.observe(c));
})();

