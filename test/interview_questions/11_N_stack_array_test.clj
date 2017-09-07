(ns interview-questions.11-N-stack-array-test
  (:require [clojure.test :refer :all]
            [interview-questions.11-N-stack-array :refer :all]
            [com.stuartsierra.component :as component]))

(def system (array-stack-system {:stacks 3 :array-size 10}))
;;=> #'examples/system

(alter-var-root #'system component/start)


(testing "Stack management using a single array."
  (is (= @data [\space \space \space \space \space \space \space \space \space \space]))

  (is (= @available-index '(0 1 2 3 4 5 6 7 8 9)))

  (is (= @used-stack-index [() () ()]))


  )

(alter-var-root #'system component/stop)
