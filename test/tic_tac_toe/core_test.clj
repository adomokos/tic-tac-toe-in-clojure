(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(deftest board-test
  (is (= [[:_ :_ :_][:_ :_ :_][:_ :_ :_]] board)))

(deftest print-board-test
  (testing "prints an empty tic-tac-toe board"
    (is (= "\n_ _ _ \n_ _ _ \n_ _ _ \n" (print-board board)))))

(deftest record-player-move-test
  (testing "records the player's move"
    (let [updated-board (record-player-move [1 1] board)]
      (is (= "\nX _ _ \n_ _ _ \n_ _ _ \n" (print-board updated-board))))
    (let [updated-board (record-player-move [1 3] board)]
      (is (= "\n_ _ X \n_ _ _ \n_ _ _ \n" (print-board updated-board))))))
