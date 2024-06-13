## 1. Perbedaan SharedFlow dan StateFlow

SharedFlow dan StateFlow adalah dua jenis flow yang digunakan dalam Kotlin Coroutines untuk menghandle data yang berubah-ubah. Perbedaan utama antara keduanya adalah:
* SharedFlow: Mengizinkan multiple observers untuk mengamati perubahan data dan dapat mengirimkan data ke multiple observers secara simultan.
* StateFlow: Hanya mengizinkan satu observer untuk mengamati perubahan data dan hanya dapat mengirimkan data ke satu observer.

## 2. 5 jenis Scoped Function dalam Kotlin

Berikut adalah 5 jenis Scoped Function dalam Kotlin:
* let: Mengizinkan kita untuk melakukan operasi pada objek dan mengembalikan hasilnya.
* run: Mengizinkan kita untuk melakukan operasi pada objek dan mengembalikan hasilnya, serta dapat digunakan untuk menginisialisasi objek.
* with: Mengizinkan kita untuk melakukan operasi pada objek dan mengembalikan hasilnya, serta dapat digunakan untuk menginisialisasi objek.
* apply: Mengizinkan kita untuk melakukan operasi pada objek dan mengembalikan objek itu sendiri.
* also: Mengizinkan kita untuk melakukan operasi pada objek dan mengembalikan objek itu sendiri.

## 3. Perbedaan unit test dan instrument test

Unit test dan instrument test adalah dua jenis testing yang digunakan dalam pengembangan aplikasi Android.
* Unit test: Menguji fungsi-fungsi individual dalam aplikasi untuk memastikan bahwa mereka berfungsi dengan benar.
* Instrument test: Menguji aplikasi secara keseluruhan, termasuk interaksi dengan sistem operasi dan perangkat keras.

## 4. Apa yang dimaksud dengan View Binding

View Binding adalah fitur dalam Android yang mengizinkan kita untuk mengakses views dalam layout XML secara langsung dalam kode Java atau Kotlin, tanpa perlu menggunakan findViewById.

## 5. Jika proses pada main thread ter-Block terlalu lama, Sistem akan menampilkan...

c. Application Not Responding

## 6. Untuk menambah features, components, dan permissions ke aplikasi android anda, File apa yang harus diubah?

c. AndroidManifest.xml

## 7. CakNorris

Aplikasi Android tentang Chuck Norris

## Deskripsi
Aplikasi ini menampilkan informasi tentang Chuck Norris, termasuk foto (jika ada), biografi, dan quotes.

## Teknologi
* Android Architecture Components (MVVM)
* Retrofit untuk API calls
* Kotlin sebagai bahasa pemrograman

## API
* https://api.chucknorris.io/jokes/random (initial default)
* https://api.chucknorris.io/jokes/search?query={query}

## Kontribusi
Jika Anda ingin berkontribusi pada proyek ini, silakan fork repository dan membuat pull request.