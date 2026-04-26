const timeEl = document.getElementById('current-time');
const dateEl = document.getElementById('current-date');
const alarmInput = document.getElementById('alarm-input');
const setBtn = document.getElementById('set-btn');
const statusEl = document.getElementById('alarm-status');
const listEl = document.getElementById('alarms-list');
const overlay = document.getElementById('alert-overlay');
const alertTime = document.getElementById('alert-time');
const dismissBtn = document.getElementById('dismiss-btn');

let alarms = JSON.parse(localStorage.getItem('alarms') || '[]');
let audioCtx = null;
let alarmNode = null;

const DAYS = ['日', '月', '火', '水', '木', '金', '土'];

function pad(n) { return String(n).padStart(2, '0'); }

function tick() {
  const now = new Date();
  const h = pad(now.getHours());
  const m = pad(now.getMinutes());
  const s = pad(now.getSeconds());
  timeEl.textContent = `${h}:${m}:${s}`;
  dateEl.textContent = `${now.getFullYear()}年${now.getMonth() + 1}月${now.getDate()}日 (${DAYS[now.getDay()]})`;

  const hhmm = `${h}:${m}`;
  if (s === '00') {
    alarms.forEach((alarm, i) => {
      if (alarm.enabled && alarm.time === hhmm) {
        triggerAlarm(alarm.time);
      }
    });
  }
}

function triggerAlarm(time) {
  alertTime.textContent = time;
  overlay.classList.remove('hidden');
  playBeep();
}

function playBeep() {
  audioCtx = new (window.AudioContext || window.webkitAudioContext)();
  function beep() {
    const osc = audioCtx.createOscillator();
    const gain = audioCtx.createGain();
    osc.connect(gain);
    gain.connect(audioCtx.destination);
    osc.frequency.value = 880;
    osc.type = 'sine';
    gain.gain.setValueAtTime(0.4, audioCtx.currentTime);
    gain.gain.exponentialRampToValueAtTime(0.001, audioCtx.currentTime + 0.6);
    osc.start();
    osc.stop(audioCtx.currentTime + 0.6);
  }
  beep();
  alarmNode = setInterval(beep, 1000);
}

function stopBeep() {
  if (alarmNode) { clearInterval(alarmNode); alarmNode = null; }
  if (audioCtx) { audioCtx.close(); audioCtx = null; }
}

dismissBtn.addEventListener('click', () => {
  overlay.classList.add('hidden');
  stopBeep();
});

setBtn.addEventListener('click', () => {
  const time = alarmInput.value;
  if (!time) { statusEl.textContent = '時刻を選んでください'; statusEl.style.color = '#e94560'; return; }
  if (alarms.find(a => a.time === time)) { statusEl.textContent = 'すでに設定済みです'; statusEl.style.color = '#e94560'; return; }
  alarms.push({ time, enabled: true });
  save();
  render();
  statusEl.textContent = `${time} にアラームをセットしました`;
  statusEl.style.color = '#4caf50';
  alarmInput.value = '';
});

function save() {
  localStorage.setItem('alarms', JSON.stringify(alarms));
}

function render() {
  listEl.innerHTML = '';
  [...alarms].sort((a, b) => a.time.localeCompare(b.time)).forEach((alarm) => {
    const idx = alarms.indexOf(alarm);
    const item = document.createElement('div');
    item.className = 'alarm-item';

    const timeSpan = document.createElement('span');
    timeSpan.className = 'alarm-time';
    timeSpan.textContent = alarm.time;

    const controls = document.createElement('div');
    controls.className = 'alarm-controls';

    const toggle = document.createElement('div');
    toggle.className = `toggle ${alarm.enabled ? 'on' : ''}`;
    toggle.addEventListener('click', () => {
      alarms[idx].enabled = !alarms[idx].enabled;
      save();
      render();
    });

    const del = document.createElement('button');
    del.className = 'delete-btn';
    del.textContent = '✕';
    del.addEventListener('click', () => {
      alarms.splice(idx, 1);
      save();
      render();
    });

    controls.appendChild(toggle);
    controls.appendChild(del);
    item.appendChild(timeSpan);
    item.appendChild(controls);
    listEl.appendChild(item);
  });
}

render();
setInterval(tick, 1000);
tick();
