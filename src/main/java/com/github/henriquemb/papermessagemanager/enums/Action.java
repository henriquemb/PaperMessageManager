package com.github.henriquemb.papermessagemanager.enums;

public enum Action {
    CLICK("click", "<click:.+:.+>", "</click>"),
    SELECTOR("selector", "<selector:.+:.+>", ""),
    NBT("nbt", "<nbt:.+:.+>", "");

    private final String name;
    private final String actionStart;
    private final String actionEnd;

    Action(String actionName, String actionStart, String actionEnd) {
        this.name = actionName;
        this.actionStart = actionStart;
        this.actionEnd = actionEnd;
    }

    public String getName() {
        return name;
    }

    public String getActionStart() {
        return actionStart;
    }

    public String getActionEnd() {
        return actionEnd;
    }

    public static String replaceAllActions(String message) {
        for (Action action : Action.values()) {
            message = replaceAction(action, message);
        }

        return message;
    }

    public static String replaceAction(Action action, String message) {
        if (action == null) {
            return message;
        }

        return message.replaceAll(action.getActionStart(), "")
            .replaceAll(action.getActionEnd(), "");
    }

    public static Action getAction(String name) {
        for (Action action : Action.values()) {
            if (action.name.equalsIgnoreCase(name)) {
                return action;
            }
        }

        return null;
    }
}
