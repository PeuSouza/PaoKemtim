function addTimer() {
    const listSpan = document.getElementsByClassName("Timer");
    for (let index = 0; index < listSpan.length; index++) {
      const tempoSaida = Number(listSpan[index].getAttribute("data-Saida"));
      const tempoAtual = new Date().getTime();
      const tempoRestante = tempoSaida - tempoAtual;
  
      const dias = Math.floor(tempoRestante / (1000 * 60 * 60 * 24));
      const horas = Math.floor(tempoRestante / (1000 * 60 * 60));
      const minutos = Math.floor(tempoRestante / (1000 * 60));
      const segundos = Math.floor(tempoRestante / 1000);
  
      const d = dias;
      const h = horas - dias * 24;
      const m = minutos - horas * 60;
      const s = segundos - minutos * 60;
  
      listSpan[index].textContent = `${format(m)}:${format(s)}`;
  
      if (tempoRestante < 0) {
        changeStyleTo(listSpan[index]);
      }
    }
  }
  
  function format(time) {
    return (time >= 10) ? `${time}` : `0${time}`;
  }
  
  function changeStyleTo(span) {
    span.textContent = "Pronta!";
    span.style.color = "#556b2f";
    span.style.animation = "changesize .7s";
    span.style.animationIterationCount = "infinite";
    span.style.animationDirection = "alternate";
  }
  
  setInterval(Timer, 1000);