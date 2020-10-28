# Просмотр .json фаила.

Для запуска программы:  
  
java -jar -Dfile.encoding=UTF-8 jfr.jar C:\projects\Json_Flight_Reader\flights.json from Москва to Хабаровск  
Так же можно не указывать from Москва to Хабаровск или указать что-то одно (или from Москва, или to Хабаровск)  
Описание:  
Напишите программу на языке программирования Java,  
которая будет считывать данные из файла flights.json (см. содержимое файла ниже)  
и выведет на экран следующие данные по перелетам из Москвы в Хабаровск:
минимальная стоимость перелета;  
средняя стоимость перелета(показывает среднее математическое значение без остатка);  
максимальная стоимость перелета.  
Программа должна вызываться из командной строки, результаты можно выводить в консоль.  

Пример файла flights.json:

```
{
    "flights":[
        {
            "fromCity": "Москва",
            "toCity": "Нижний Новгород",
            "price": 5000,
        },
        {
            "fromCity": "Москва",
            "toCity": "Хабаровск",
            "price": 12000,
        },
        {
            "fromCity": "Хабаровск",
            "toCity": "Москва",
            "price": 14000,
        },
        {
            "fromCity": "Москва",
            "toCity": "Хабаровск",
            "price": 12500,
        },
        {
            "fromCity": "Москва",
            "toCity": "Хабаровск",
            "price": 11000,
        },
        {
            "fromCity": "Хабаровск",
            "toCity": "Нижний Новгород",
            "price": 13000,
        }
    ]
}
```