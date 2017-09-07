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

(defrecord ArrayStack [stacks array-size]
  ;; Implement the Lifecycle protocol
  component/Lifecycle

  (start [component]
    (println ";; Starting ArrayStack")
    ;; In the 'start' method, initialize this component
    ;; and start it running. For example, connect to a
    ;; database, create thread pools, or initialize shared
    ;; state.
    (let [stack-count stacks
          array-size array-size
          data (atom (apply vector-of :char (repeat array-size \space)))
          available-index (atom (apply list (range 0 array-size)))
          used-stack-index (atom (apply vector (repeat stack-count '())))]
      ;; Return an updated version of the component with
      ;; the run-time state assoc'd in.

      (assoc component :data data
                       :available-index available-index
                       :used-stack-index used-stack-index)))

  (stop [component]
    (println ";; Stopping ArrayStack")
    ;; In the 'stop' method, shut down the running
    ;; component and release any external resources it has
    ;; acquired.
    ;; Return the component, optionally modified. Remember that if you
    ;; dissoc one of a record's base fields, you get a plain map.
    (assoc component :data nil
                     :available-index nil
                     :used-stack-index nil)))

;; Constructor method
(defn new-array-stack [stacks array-size]
  (map->ArrayStack {:stacks stacks :array-size array-size}))

(defn array-stack-system [config-options]
  (let [{:keys [stacks array-size]} config-options]
    (component/system-map
      :array-stack (new-array-stack stacks array-size))))

(defn push-to-stack [ArrayStack stack-ind val]
  (when-let [i (peek (deref (:available-index ArrayStack)))]
    (do
      (swap! (:available-index ArrayStack) pop)
      (swap! (:used-stack-index ArrayStack) update-in [stack-ind] #(conj % i) )
      (swap! (:data ArrayStack) assoc i val) ;; last so returns
      )
    )
  )

(defn pop-from-stack [ArrayStack stack-ind]
  (when-let [i (peek (get-in (deref (:used-stack-index ArrayStack)) [stack-ind]))]
    (let [val (get (deref (:data ArrayStack)) i)]
      (swap! (:available-index ArrayStack) conj i)
      (swap! (:used-stack-index ArrayStack) update-in [stack-ind] pop)
      (swap! (:data ArrayStack) assoc i \space)
      val ;; return the data popped off the top
      )
    )
  )