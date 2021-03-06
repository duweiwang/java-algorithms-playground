此部分代码和笔记摘自-极客时间


作者从经典的换领钱问题出发，逐步深入的剖析问题的本质：
1、贪心求局部最优解，希望得到整体最优解
2、贪心无法得到整体最优，需要进行回溯
3、回溯问题等同于递归状态的保存，使用递归栈来保存回溯状态。
4、递归存在重复计算，需要进行剪枝，使用备忘录保存历史计算结果
5、递归是一种自顶向下的求解方法，如何自底向上求解问题呢？



动态规划问题一定具备以下三个特征：
1、重叠子问题：在穷举的过程中（比如通过递归），存在重复计算的现象；
2、无后效性：子问题之间的依赖是单向性的，某阶段状态一旦确定，就不受后续决策的影响；
3、最优子结构：子问题之间必须相互独立，或者说后续的计算可以通过前面的状态推导出来。