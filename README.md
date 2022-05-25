# EasyMoneySystem 
An easy spigot money system using [PlayerPrefs](https://github.com/emilkrebs/PlayerPrefs).

<a href="https://www.buymeacoffee.com/emilkrebs" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" style="height: 60px !important;width: 217px !important;" ></a>

## Getting started

- Clone the repository using ``git clone https://github.com/emilkrebs/EasyMoneySystem.git``
- Build the artifacts
- Copy the jar to your plugin folder download directly from [releases](https://github.com/emilkrebs/EasyMoneySystem/releases)

## Commands

``pay <receiver> <amount>``  Pay another player a amount of your money

``bal``  Get your or others current balance

## Config

```yaml
startMoney: 100 # The amount of money every new player gets

```
## Features
- When a player gets killed all his money will be transferred to the killer.
- Everything is saved into .yml files to avoid losing data on server crashes.
- Every new player gets a specific amount of money.
- Easy code.

## Known Issues

None

[Add Issue](https://github.com/emilkrebs/EasyMoneySystem/issues/new)
