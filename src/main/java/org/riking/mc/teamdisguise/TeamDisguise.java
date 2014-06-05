package org.riking.mc.teamdisguise;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.UUID;

public class TeamDisguise extends JavaPlugin implements Listener {
    @Override
    public void onLoad() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getCommand("red").setExecutor(this);
        getCommand("blue").setExecutor(this);
        getCommand("green").setExecutor(this);
        getCommand("yellow").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    private static final String redBlob, redSig, grnBlob, grnSig, yloBlob, yloSig, bluBlob, bluSig;

    static {
        redBlob = "eyJ0aW1lc3RhbXAiOjE0MDE5Mzk3MTE3MTMsInByb2ZpbGVJZCI6IjFlMzJjMzg0YjE4ZjRjMmI4NTZiNThiNmI2YzE0MzVjIiwicHJvZmlsZU5hbWUiOiJPaW5uZXJib25lIiwiaXNQdWJsaWMiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iMDRhZmQ0OWNmMTM0ZjM5ZTI4MmZmNzI5MDFiZDkxMzk2OWZkMDgyNDk0ZWI4YjdmZWY5MjFkYWNkMTgifX19";
        redSig = "fbDwrqKYlfrfEOh6CdJAnKGXqIW2C5/PWveuuBUV6WjC3tFWxuL3XvNWXDKYKNsFwv9hvlgpJ2fb0eb45Z8WXVo0I3uUDt0VC7E0CzOeiV9s3rztUHK23IT4yzyb7fbl30eyUKlqWXGH69CSkGrPi9hlA85uBHqLr8d78LdeBMDSeZq4cJVD6dJVIWflrLpy5qu2sey5Vg7eEOPfM8T73hotsZZsviHZDX5meAWtEVWzucoYDDPluHYxtI/dCRyRVDheAkwLw+suiQQp0znl09+D7ZaIG5HmZkK4rY0hKxlnctIcUDgeAdCshffsOASrDd8iBasKWa2eqWVA7Qfm4YjeiPHTLgSLlOVnvNB0g3WpmUxW7G8U54HB186HGsD85+8vnURbcnMLJS1+TgGSCUFewcs6NAU4KRAMmnk93jHeC8AVupTn8IpGkySIsnWL8b2LRxRa+A0kIVVJD7t4i9SfrESNxuwZKsZ3A0axwN6YlzAH3Pt60KM9oVKzzvkMFB1LnrlrU8qgaoFaEDqfb38RbAxlkB+pRFUlz7HbIC++fNNr+/g3rGP6eSE3ExIoBl5vnRwndwAuX4q1y8OkFq/VmjXx4yBmpobI3FquFD0W9SpIvRs6mv7mXtbHdaK/+qi9gcbmHYhF7XUR4OYoFizNmCcPdi6DbiSbFKGC58k=";

        grnBlob = "eyJ0aW1lc3RhbXAiOjE0MDE5Mzk1NTcwNzUsInByb2ZpbGVJZCI6IjFlMzJjMzg0YjE4ZjRjMmI4NTZiNThiNmI2YzE0MzVjIiwicHJvZmlsZU5hbWUiOiJPaW5uZXJib25lIiwiaXNQdWJsaWMiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hN2ExZWE3NjM1N2U0ZTJiMGIxZDU0ZmM1MGFhOWI4NzYyYTFkNjJhOTgxZjNlMDY5ZGYxOGIzZTRlNzM0In19fQ==";
        grnSig = "hpS5cdYWGDkfblLFoZJCxxX1rXrNu4/IEmgpea0IXCu6DAVoUK8hwkem3Maes1kdph47DDUJzPQM3nH0h47uPUydm8mVljkEo3AouCVFO9Sg9dq8dWj+Gv60NeSowuTre2P9ZB06Eo//bSmucxJP7E+6mYcAf3vWzBeJSUqEFi4PWb6FHuSx/qNGF2HGMR+9yUCSPGMkhz8npWzYJMkNAJDVqOzPjOXQmxB+9Ugruh8UA1bRFZYrZNbOYhpSqCqUCDAqqYbRJnQYhKkmqCYBUSIWzPos1Ker4mnLcs/IAu74ojJlKcx+IglqRgHfBnl1rMgr5AmYhHz2YAyHLtXDGfYkFl06TTLN59bpTq2m0Eybf/9xUSAVsiJzcs2Wn88Gatj1RE3uXlValpGSTbou8lyK8+dr04ac4IKLMcYR23hPGvo65jvowmIqOfzH44BS8mYQq2+g95kL5VxzQY56yrTwhS0b7Fe49UCboa2r+nTDAhQMQ5pZr5YKfkk/aQ33mxzJYfcs1sWEvANbfTol8SjRSn2haABEguN+ZU8BRBdnQXKdCNqJzVmSc+Hq5bPm0jUhUtzlCS4LPeTlIgvHklYhJqMg3qey5VyYM7wbH3TE9usP0aATqmzxOmTe1oWbojf57WCIFAhPjqH5k7o7p/Pb6t8piB0692tdq+rC2uI=";

        yloBlob = "eyJ0aW1lc3RhbXAiOjE0MDE5Mzk3Njc1NjYsInByb2ZpbGVJZCI6IjFlMzJjMzg0YjE4ZjRjMmI4NTZiNThiNmI2YzE0MzVjIiwicHJvZmlsZU5hbWUiOiJPaW5uZXJib25lIiwiaXNQdWJsaWMiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yNDJlYTVhMWFjNDBlY2RmY2U1M2E5ZjE1YWMxMmE2ZDliN2EwMThlYTU5N2FlYTgzN2JmMjJhOTg0MTE4ODIifX19";
        yloSig = "yDHKrOXGw70BJB6iNrkMGkiFBlRZT7FriMjA/clievgVG/HH8hE/1WCXd/cLLr7xz5WH7KFkjGtPw6lWB2t4Rn4AH2hrSlaD64ep9anijcNiBqvba/Pj7Y41rBQe/E6GTiS1C5Hhv8Z8cWbtcW9DhKu3LXJNb4EFT2lhDQZ4r/NwrYQnLEiB5Z4XqxSyIbgpttFu7iBtKwUH5vliaxCQkaLULXi896RIe5qvSyuTp9byRoDVffXOWUBo2TvVz3rNsqSlzTi2cMK6CGawuxHeSxMeMMNlj8fAtRr3CiqyM+oYqUnp7v1mcKjcE7zFqAwzS/UgxHp8qZ0y5J2bUy/cUHAPteiVPb95OrjUfGfI+HwMw1DCjEZUo3jBP+NCkBsIxXqLkvXAiLwyI4MEU/zLiLbOPpKoaHnVk5ryEx7VP6D7OOSK2iDFgRSrxO1/3rlp4qeBOGQfw2O1wGnNf86WpdDEflqZ0pQd/axsmRaKsasnch0sq8OPAVqG5LZB5Ts9a0lR8QEcF99eCpO7P5BEAPESM9A36g+cvUItAVVAxD0jYC92BldQYTx591P+2UcFf1ZUi1zc20dQHL/nliw5BxbWHiZDoWLmtkKGqyddf2sCKcVgSJOtUvC+2RUA4ckuq8f9hb8hk5McImuuaQV3F6RhYYqVOXZDh7hGBeOcT9s=";

        bluBlob = "eyJ0aW1lc3RhbXAiOjE0MDE5Mzk4MTIxNzIsInByb2ZpbGVJZCI6IjFlMzJjMzg0YjE4ZjRjMmI4NTZiNThiNmI2YzE0MzVjIiwicHJvZmlsZU5hbWUiOiJPaW5uZXJib25lIiwiaXNQdWJsaWMiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84NTg5MTJhYzQ2MTRhMDk3NGI1ZjQ1NzAyN2Q3ZmI5NmExMjBkZDZjN2Q0MTY0ZmE5OWI4ZWM4ZWI4MDdiMTcifX19";
        bluSig = "YSyh9LmFrG9HtTiBNJExYDRcsdQO1GsBpEBKNH5zWcU3wnYw4QqVpYi18IYAyNqSyEvH8+wGKTYNFKmq3yNmwfe+OlvfmxgCpHNmBVIifZAPHdIe05Dy+l0tYrZ+xa8bKFGAtImJHbXVw+IIgf+S+yaOSneMsH7LZXRJNAg82QtKBAKS6NFAMxcpx1wKOkllZafF0VMqB1UmPnNrtQZC4eVwtSwLGESKWdMvArsW4QqfT44yrp5sR55UNJpNWlHnnhA3EPllxorIYyafCswOp9tisS2vSes072LAVGROUUChNAWIMwTk4TxoEw8JwyypwMQq01RWOhCheRHXpGY3OoljjFXjJHCIWkAMhcqNublyZVNDIB0Q6ZQis50Y1zn6ZZ6wZphnCiFp1rN5UuZOEtTmJ/AnaWdCqgovGEoJvUJgN5ZiIj229I0jhPft9r3gtHRwzvEcRTkUub8CuvhvTQFMCY0P5xHTbabYyb34PNJ/wE4kaWZ2qKh2WsxCQMnZSF1L8Aayg+n6pz9kGjNamz00FWv5EsraQy3cWxsw6dGEiUlnx69bN9FQupdpeiKp4i+svCc8cS/YrYtBfJcexqThW3xFcpKLf5U/NWFoyh27eosPQSrv5qavuV4vEUeEDSNDVDp1HWUOVACsbE87v+p/GiC/edS5Zk5UHgmu8O4=";
    }

    private makeGameProfile(UUID uuid, String name, String blob, String signature) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return super.onTabComplete(sender, command, alias, args);
    }
}
