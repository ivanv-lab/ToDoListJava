# ToDoList

Написать прототип приложения "Список задач". Задача описывается состоянием (сделано/не сделано) и описанием того, что надо сделать.
Ввод данных выполняется через консоль. Программа должна поддерживать следующие команды:
- add - добавление задачи
- print - печать списка задач
- toggle - изменение статуса задачи
- quit - завершение работы
- delete - удаление задачи
- edit - изменение описания задачи
- search - поиск задачи

Добавление новой задачи заменяет ту, которая в данный момент сохранена. 
Данные хранить в оперативной памяти. Необходимо предусмотреть обработку ошибок: неправильный формат ввода данных, некорректные аргументы команд.

Для сборки использовать maven, репозиторий также должен содержать файл readme.md с описанием (которое сейчас вы и читаете).

## Описание команд

### add
Формат команды: add <описание задачи>

Описание задачи может содержать любые символы, кроме перевода строки.
Перевод строки (нажатие клавиши Enter) означает завершение ввода описания задачи.

### print
Формат команды: print [all]

Выводит на печать список задач. 
По-умолчанию выводятся только невыполненные задачи, в случае если команда выполняется с аргументом all - печатаются все задачи.
Печатаются следующие поля: идентификатор (номер, в данном случае всегда "1"), который используется в команде toggle,
статус задачи (x - выполнена, " " - не выполнена), описание задачи.

### toggle
Формат команды: toggle <идентификатор задачи>

Переключает состояние задачи (с "выполнена" на "не выполнена" и наоборот) по идентификатору. 

### quit
Формат команды: quit

Завершает работу программы

### search
Формат команды: search <substring>

Выводит на печать список задач, описание которых содержит substring. Вывод на печать в формате аналогичном команде print.

Пример вывода:

3. [x] Реализовать сборку на maven
8. [ ] Реализовать сборку на gradle


### delete
Формат команды: delete <идентификатор задачи>

Удаляет задачу из списка задач.

### edit
Формат команды: edit <идентификатор задачи> <новое значение>

Меняет описание задачи.
