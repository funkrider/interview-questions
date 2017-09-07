(ns interview-questions.05-Stack-push-pop-max)

;; Create a stack with push, pop and max functions
;; that all operate in O(1) time.

;; Stack is LIFO - Clojure list gives conj, pop

;; The Clojure way is to have a function that operates
;; on a datastructure - not quite the same as a method or
;; field on an object. The instance of stack should have
;; state - that holds the current max.
;; State should have (count [int], max [int], max-index[stack])
;; Max-count is a stack that holds essentially the index
;; of every value that is a new max.
;; Push - will increment count, if (> value max)
;;   then swap! max ,and add to (push max-index count)
;; Pop - will decrement count, if (= value max)
;;   then (pop max-count), and pop stack

(def a-stack (atom '()))
(def max-value (atom Integer/MIN_VALUE))
(def max-index-stack (atom '()))

;; Private funcs declare first
(defn- push-new-max [max-value-atom max-index-stack-atom index value]
  "If the new value is greater than in max-value-atom, update with this new value.
  Then add a new item to the max-index-stack"
  (when (> value @max-value-atom)
    (reset! max-value-atom value)
    (swap! max-index-stack-atom #(conj % index)))
  )

(defn- pop-new-max [max-value-atom max-index-stack-atom index stack-atom]
  "If the popped index is equal to the head of the max-index-stack
  then pop the max-index and set the max-value to the new head."
  (when (= index (peek @max-index-stack-atom))
    (swap! max-index-stack-atom pop)
    (reset! max-value-atom (nth @stack-atom
                                (or (peek @max-index-stack-atom) 0)
                                Integer/MIN_VALUE)))
  )



(defn pushx [stack-atom value max-value-atom max-index-stack-atom]
  "adds the value to our stack atom and returns the new stack"
  (push-new-max max-value-atom max-index-stack-atom (count @stack-atom) value)
  (swap! stack-atom #(conj % value)))

(defn popx [stack-atom max-value-atom max-index-stack-atom]
  "pops the head off the stack and returns the value popped off"
  (let [head (peek @stack-atom)]
    (swap! stack-atom pop)
    (pop-new-max max-value-atom max-index-stack-atom (count @stack-atom) stack-atom)
    head))

(defn debugPrint []
  (prn "a-stack " @a-stack)
  (prn "max-value " @max-value)
  (prn "max-index-stack " @max-index-stack)
  )