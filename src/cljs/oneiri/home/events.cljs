(ns oneiri.home.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 ::search
 (fn  [db _]
   (js/console.log (str "Search for: " (::q db)))))

(re-frame/reg-event-db
 ::set-q
 (fn  [db [_ q]]
   (assoc db ::q q)))
