
main函数，就是创建图，以后遍历peers，每个都在genesis block 后创建一个块，同时创建个事件，类型为2

有了块后，接着遍历peers，每个创建一个transaction ，同时创建事件，类型为4

有了块和transaction，就遍历事件，按照事件类型执行就好了




