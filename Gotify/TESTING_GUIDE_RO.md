# Ghid de Testare - Gotify Android 🇷🇴

## 📱 Cum să testezi aplicația

### Opțiunea 1: Butonul de Test (CEL MAI SIMPLU) ✨

Am adăugat un **buton plutitor (+)** în aplicație care îți permite să creezi mesaje de test instant!

**Pași:**
1. Deschide aplicația Gotify
2. Vei vedea un buton albastru (+) în colțul din dreapta jos
3. Apasă pe butonul (+) 
4. **BOOM!** 🎉 - Vei primi:
   - Un mesaj nou în listă
   - O notificare push pe ecran
   - Mesajul va apărea ca "Unread" (necitit)

**Poți apăsa de câte ori vrei pentru a crea mai multe mesaje de test!**

---

### Opțiunea 2: SMS Real (Pe Telefon Real)

Pentru a testa cu SMS-uri reale:

1. **Asigură-te că ai acordat permisiunile:**
   - SMS Receive (Primire SMS)
   - SMS Read (Citire SMS)
   - Notificări

2. **Trimite un SMS la telefonul tău:**
   - De pe alt telefon, trimite un SMS la numărul tău
   - SMS-ul va apărea automat în Gotify
   - Vei primi o notificare
   - Mesajul va fi salvat în baza de date

---

### Opțiunea 3: Testare pe Emulator

Dacă folosești emulatorul Android Studio:

1. **Pornește emulatorul**

2. **Deschide Extended Controls:**
   - Apasă pe butonul `...` (trei puncte) din bara laterală a emulatorului
   - SAU folosește prescurtătura: `Ctrl+Shift+P` (Windows) sau `Cmd+Shift+P` (Mac)

3. **Trimite SMS:**
   - Click pe secțiunea **Phone** → **SMS messages**
   - În câmpul "Sender phone number", pune un număr (ex: `+40123456789`)
   - În câmpul "Message", scrie textul mesajului
   - Click pe butonul **"Send Message"**

4. **Vezi rezultatul:**
   - SMS-ul va apărea în aplicația Gotify
   - Vei primi o notificare
   - Mesajul va fi salvat

---

## 🎯 Funcționalități de Testat

### ✅ Lista de Verificare:

- [ ] **Primire mesaj**: Creează un mesaj de test cu butonul (+)
- [ ] **Notificare**: Vezi dacă apare notificarea
- [ ] **Indicator Unread**: Verifică punctul albastru și badge-ul de unread
- [ ] **Click pe mesaj**: Deschide detaliile mesajului
- [ ] **Marcare ca citit**: Mesajul devine "read" automat când îl deschizi
- [ ] **Ștergere mesaj**: Apasă butonul de delete (🗑️) în detalii
- [ ] **Ștergere toate**: Menu (⋮) → "Delete all messages"
- [ ] **Navigare înapoi**: Butonul de back funcționează corect

---

## 🔔 Testare Notificări

### Dacă notificările nu funcționează:

1. **Verifică permisiunile:**
   ```
   Settings → Apps → Gotify → Permissions
   - SMS: Allow
   - Notifications: Allow
   ```

2. **Verifică setările de notificare:**
   ```
   Settings → Apps → Gotify → Notifications
   - Activează toate notificările
   - Verifică prioritatea (High/Medium)
   ```

3. **Verifică "Do Not Disturb":**
   - Dezactivează modul "Do Not Disturb" dacă este activ

4. **Testează din nou:**
   - Apasă butonul (+) pentru mesaj de test
   - Ar trebui să vezi notificarea instant

---

## 📊 Exemple de Mesaje de Test

Când apeși butonul (+), vei primi mesaje aleatorii ca:

**Expeditori:**
- +1234567890
- +9876543210
- John Doe
- Jane Smith
- Tech Support
- Banking Alert
- Delivery Service

**Mesaje:**
- "Hello! How are you doing today?"
- "Your package has been delivered successfully."
- "Meeting scheduled for 3 PM tomorrow."
- "Your verification code is 123456"
- "Congratulations! You've won a prize."
- Și multe altele!

---

## 🐛 Probleme Comune

### 1. **Mesajele nu apar**
**Soluție:** 
- Verifică permisiunile SMS
- Încearcă să apeși butonul (+) pentru test
- Verifică logs în Android Studio (Logcat)

### 2. **Notificările nu se afișează**
**Soluție:**
- Settings → Apps → Gotify → Notifications → Allow
- Verifică dacă notificările sunt blocate la nivel de sistem

### 3. **Aplicația se închide**
**Soluție:**
- Clear data: Settings → Apps → Gotify → Storage → Clear Data
- Reinstalează aplicația
- Verifică Logcat pentru erori

### 4. **SMS-urile apar și în aplicația de mesaje**
**Normal!** Gotify interceptează SMS-urile dar nu le blochează din aplicația default. Ambele aplicații vor afișa mesajele.

---

## 💡 Tips & Tricks

1. **Test Rapid:** Folosește butonul (+) pentru a genera rapid mesaje de test
2. **Unread Counter:** Numărul din badge arată câte mesaje necitite ai
3. **Swipe Refresh:** (viitoare funcționalitate)
4. **Dark Mode:** Urmează tema sistemului automat
5. **Timestamp:** Mesajele sunt sortate de la cel mai nou la cel mai vechi

---

## 📝 Note Importante

- **Mesajele de test** au timestamp-uri aleatorii din ultimele 7 zile
- **Prioritatea** este aleatorie între 1-10
- **Status-ul citit/necitit** este aleatoriu pentru mesajele de test
- **SMS-urile reale** sunt întotdeauna marcate ca necitite inițial

---

## 🎉 Bucură-te de Aplicație!

Acum poți testa aplicația Gotify fără să aștepți SMS-uri reale! 

**Butonul (+) este prietenul tău pentru testare rapidă!** 🚀

---

## 📞 Debugging

Pentru dezvoltatori, verifică în **Logcat**:

```
Tag: SmsReceiver
Tag: NotificationService
```

Vezi log-urile pentru:
- Primirea SMS-urilor
- Salvarea în baza de date
- Afișarea notificărilor

---

**Creat cu ❤️ pentru testare ușoară!**

