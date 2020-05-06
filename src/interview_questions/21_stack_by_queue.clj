(ns interview-questions.21-stack-by-queue)

;;; Create a stack with push and pop methods
;;; using a queue data structure as the base.
;;; Assume integer is the data type.

;;; Stack FIFO vector/list
;;; Queue LIFO - clojure.lang.PersistentQueue

;;; Two possible methods:
;;; 1) Use 2 Queues and push into an empty one,
;;; then pop the other one into it.
;;; 2) Pop the items off the queue until length=1
;;; every time you want to pop.
