(ns oneiri.home.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 :something
 (fn  [_ _]))
