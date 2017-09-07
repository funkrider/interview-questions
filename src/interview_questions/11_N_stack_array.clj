(ns interview-questions.11-N-stack-array
  (:require [com.stuartsierra.component :as component]))

;;; Using a single array (Vector) keep track of a variable
;;; number of stacks. All the data must be kept in the single
;;; array and no stack should be full until the entire array
;;; is full. You may use other arrays or variables to keep
;;; track of where items are in the data array.

;;; Push-to-stack (stack-index, data) -> nil
;;; Pop-from-stack (stack-index) -> data

;;; Assume char input data to help differentiate from index
;;; Assume limit of 10 items
;;; Assume 3 stacks

;;; Have stack of available index slots '(0 1 2 3 4 5...)
;;; Have 2 dim array of Used stack index [ [0, 3] [1] [2, 4] ]
;;; Push - takes index off available stack puts into used array
;;; Pop - takes index off the used and adds back to available

(def ^:dynamic stack-count 3)
(def ^:dynamic array-size 10)
(def ^:dynamic data (atom (apply vector-of :char (repeat array-size \space))))
(def ^:dynamic available-index (atom (apply list (range 0 array-size))))
(def ^:dynamic used-stack-index (atom (apply vector (repeat stack-count '()))))

(defn push-to-stack [stack-ind val]
  (when-let [i (peek @available-index)]
    (do
      (swap! available-index pop)
      (swap! used-stack-index update-in [stack-ind] #(conj % i) )
      (swap! data assoc i val) ;; last so returns
      )
    )
  )

(defn pop-from-stack [stack-ind]
  (when-let [i (peek (get-in @used-stack-index [stack-ind]))]
    (let [val (get @data i)]
      (swap! available-index conj i)
      (swap! used-stack-index update-in [stack-ind] pop)
      (swap! data assoc i \space)
      val ;; return the data popped off the top
      )
    )
  )