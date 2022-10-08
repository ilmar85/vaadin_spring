package be.webtechie.vaadin.pi4j.views.led;

import be.webtechie.vaadin.pi4j.service.Pi4JService;
import be.webtechie.vaadin.pi4j.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("LED")
@Route(value = "LED", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LEDView extends HorizontalLayout {

    public LEDView(@Autowired Pi4JService pi4JService) {
        var turnOnOff = new Checkbox("Turn the LED on");
        turnOnOff.addValueChangeListener(e -> pi4JService.setLedState(e.getValue()));


        var button = new Button("1", VaadinIcon.LIGHTBULB.create());
        var button2 = new Button("2", VaadinIcon.LIGHTBULB.create());
        var button3 = new Button("3", VaadinIcon.LIGHTBULB.create());
        var button4 = new Button("4", VaadinIcon.LIGHTBULB.create());
        var button5 = new Button("5", VaadinIcon.LIGHTBULB.create());
        var button6 = new Button("6", VaadinIcon.LIGHTBULB.create());
        var button7 = new Button("7", VaadinIcon.LIGHTBULB.create());
        var button8 = new Button("8", VaadinIcon.LIGHTBULB.create());
        var button9 = new Button("9", VaadinIcon.LIGHTBULB.create());
        var button10 = new Button("10", VaadinIcon.LIGHTBULB.create());

        Button turnOffAllLightsButton = new Button("Выключить свет везде", VaadinIcon.LIGHTBULB.create());

        VerticalLayout verticalLayout = new VerticalLayout(
                new HorizontalLayout(button, button2, button3, button4, button5),
                new HorizontalLayout(button6, button7, button8, button9,button10),
                turnOffAllLightsButton);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, turnOnOff);
        final Div div = new Div(turnOnOff, verticalLayout);
        div.getStyle().set("background","url(frontend/themes/pi4jdemo/cover.jpg)");
        add(div);
    }

}
