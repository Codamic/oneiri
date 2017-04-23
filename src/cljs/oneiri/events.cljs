(ns oneiri.events
    (:require [re-frame.core :as re-frame]
              [oneiri.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :set-communication-state
 (fn [db [_ state]]
   (update-in db [:communication :state] (fn [_] state))))
