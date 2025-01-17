package org.tasks.compose

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.tasks.R
import org.tasks.Tasks
import org.tasks.compose.components.AnimatedBanner
import org.tasks.themes.TasksTheme

@ExperimentalAnimationApi
@Composable
fun NotificationsDisabledBanner(
    visible: Boolean,
    settings: () -> Unit,
    dismiss: () -> Unit,
) {
    AnimatedBanner(
        visible = visible,
        title = stringResource(id = R.string.enable_reminders),
        body = stringResource(id = R.string.enable_reminders_description),
        dismissText = stringResource(id = R.string.dismiss),
        onDismiss = dismiss,
        action = stringResource(id = R.string.TLA_menu_settings),
        onAction = settings,
    )
}

@ExperimentalAnimationApi
@Composable
fun SubscriptionNagBanner(
    visible: Boolean,
    subscribe: () -> Unit,
    dismiss: () -> Unit,
) {
    AnimatedBanner(
        visible = visible,
        title = stringResource(id = R.string.enjoying_tasks),
        body = stringResource(id = if (Tasks.IS_GENERIC) {
            R.string.donate_nag
        } else {
            R.string.support_development_subscribe
        }),
        dismissText = stringResource(id = R.string.donate_maybe_later),
        onDismiss = dismiss,
        action = stringResource(id = if (Tasks.IS_GENERIC) {
            R.string.donate_today
        } else {
            R.string.button_subscribe
        }),
        onAction = subscribe
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuietHoursBanner(
    visible: Boolean,
    showSettings: () -> Unit,
    dismiss: () -> Unit,
) {
    AnimatedBanner(
        visible = visible,
        title = stringResource(R.string.quiet_hours_in_effect),
        body = stringResource(R.string.quiet_hours_summary),
        dismissText = stringResource(id = R.string.dismiss),
        onDismiss = dismiss,
        action = stringResource(id = R.string.TLA_menu_settings),
        onAction = showSettings,
    )
}

@ExperimentalAnimationApi
@Composable
fun BeastModeBanner(
    visible: Boolean,
    showSettings: () -> Unit,
    dismiss: () -> Unit,
) {
    AnimatedBanner(
        visible = visible,
        title = stringResource(id = R.string.hint_customize_edit_title),
        body = stringResource(id = R.string.hint_customize_edit_body),
        dismissText = stringResource(id = R.string.dismiss),
        onDismiss = dismiss,
        action = stringResource(id = R.string.TLA_menu_settings),
        onAction = showSettings,
    )
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Preview(showBackground = true, backgroundColor = 0x202124, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun NotificationsDisabledPreview() = TasksTheme {
    NotificationsDisabledBanner(visible = true, settings = {}, dismiss = {})
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Preview(showBackground = true, backgroundColor = 0x202124, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BeastModePreview() = TasksTheme {
    BeastModeBanner(visible = true, showSettings = {}, dismiss = {})
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Preview(showBackground = true, backgroundColor = 0x202124, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SubscriptionNagPreview() = TasksTheme {
    SubscriptionNagBanner(visible = true, subscribe = {}, dismiss = {})
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Preview(showBackground = true, backgroundColor = 0x202124, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun QuietHoursPreview() = TasksTheme {
    QuietHoursBanner(visible = true, showSettings = {}, dismiss = {})
}
