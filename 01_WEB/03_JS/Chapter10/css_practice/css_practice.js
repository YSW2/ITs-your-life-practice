class Box {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.r = 255;
    this.g = 255;
    this.b = 255;
    this.horizon = 1;
    this.vertical = 1;
  }

  changeR(r) {
    this.r = r;
  }
  changeG(g) {
    this.g = g;
  }
  changeB(b) {
    this.b = b;
  }
  changeH() {
    this.horizon = 1 - this.horizon;
  }
  changeV() {
    this.vertical = 1 - this.vertical;
  }
  getX() {
    return this.x;
  }
  getY() {
    return this.y;
  }
  setX(x) {
    this.x = x;
  }
  setY(y) {
    this.y = y;
  }
}

window.onload = () => {
  const vpWidth = window.innerWidth;
  const vpHeight = window.innerHeight;

  const getRandom = (x, y) => Math.floor(Math.random() * (y - x) + x);

  const effect = (x, y, r, g, b) => {
    const newElement = document.createElement('div');

    Object.assign(newElement.style, {
      width: '150px',
      height: '150px',
      backgroundColor: `rgb(${r}, ${g}, ${b}, ${0.3})`,
      position: 'fixed',
      top: `${y}px`,
      left: `${x}px`,
      transition: 'all 0.3s ease-out',
    });

    document.body.appendChild(newElement);

    setTimeout(() => {
      newElement.style.opacity = '0';
      newElement.style.transform = 'scale(2)';

      setTimeout(() => {
        document.body.removeChild(newElement);
      }, 300);
    }, 30);
  };

  const render = (x, y) => {
    const box = document.createElement('div');
    const boxObject = new Box(x, y);

    let squareX = 150;
    let squareY = 150;

    let dX;
    let dY;
    let acc = 10;

    Object.assign(box.style, {
      height: `${squareY}px`,
      width: `${squareX}px`,
      position: 'fixed',
      transition: 'background-color 0.3s ease',
    });

    setInterval(() => {
      if (0 > x || x + squareX >= vpWidth) {
        boxObject.changeH();
        effect(x, y, boxObject.r, boxObject.g, boxObject.b);
      }
      if (0 > y || y + squareY >= vpHeight) {
        boxObject.changeV();
        effect(x, y, boxObject.r, boxObject.g, boxObject.b);
      }

      dX = boxObject.horizon ? 1.5 : -1.5;
      dY = boxObject.vertical ? 1 : -1;

      dX *= acc;
      dY *= acc;

      x += dX;
      y += dY;

      boxObject.setX(x);
      boxObject.setY(y);

      Object.assign(box.style, {
        top: `${y}px`,
        left: `${x}px`,
      });
    }, frame);

    setInterval(() => {
      boxObject.changeR(getRandom(0, 255));
      boxObject.changeG(getRandom(0, 255));
      boxObject.changeB(getRandom(0, 255));

      box.style.backgroundColor = `rgb(${boxObject.r}, ${boxObject.g}, ${boxObject.b}, 0.6)`;
    }, 300);

    document.body.appendChild(box);

    return boxObject;
  };

  const detectCollision = (box1, box2) => {
    let diffX = Math.abs(box1.getX() - box2.getX());
    let diffY = Math.abs(box1.getY() - box2.getY());
    if (diffX < 152 && diffY < 152) {
      if (diffX < diffY) {
        box1.changeV();
        box2.changeV();
      } else {
        box1.changeH();
        box2.changeH();
      }
      effect(box1.x, box1.y, box1.r, box1.g, box1.b);
      effect(box2.x, box2.y, box2.r, box2.g, box2.b);
    }
  };

  const isAxisDuplicated = (x, y, boxList) => {
    for (let box of boxList) {
      if (Math.abs(box.x - x) < 152 && Math.abs(box.y - y) < 152) return true;
    }
    return false;
  };

  const button = document.getElementById('addBox');
  const boxList = [];
  const frame = 1000 / 45;

  button.addEventListener('click', () => {
    let x = getRandom(0, vpWidth - 150);
    let y = getRandom(0, vpHeight - 150);

    do {
      x = getRandom(0, vpWidth - 150);
      y = getRandom(0, vpHeight - 150);
    } while (isAxisDuplicated(x, y, boxList));

    const box = render(x, y);

    boxList.push(box);
  });

  setInterval(() => {
    for (let i = 0; i < boxList.length; i++) {
      for (let j = i + 1; j < boxList.length; j++) {
        detectCollision(boxList[i], boxList[j]);
      }
    }
  }, frame);
};
