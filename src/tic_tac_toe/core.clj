(ns tic-tac-toe.core
  (require [tic-tac-toe.game :refer :all])
  (:gen-class))

(def state (atom :running))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "You are with X. Where do you want to move?")

  (let [game-board (atom board)]
    (while (= @state :running)
      (let [move (read-line)
            ]
        (if (pos? (count move))
          (do
            (swap! game-board record-move move :X)
            (println (print-board @game-board))
            (println (str "You moved to: " move)))
          (reset! state :stop))))))
